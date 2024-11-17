package cn.com.nadav.sms.handler.codec.sgip;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractSequenceNumberGenerator implements SequenceNumberGenerator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMddHHmmss");

    private final int nodeId; // 命令源节点编号

    private final AtomicReference<SequenceState> state; // 保存时间戳和当前序列号范围的状态

    public AbstractSequenceNumberGenerator(int nodeId) {
        this.nodeId = nodeId;
        String initialTimestamp = getCurrentTimestamp();
        int initialSequenceId = getInitialSequenceId();
        this.state = new AtomicReference<>(new SequenceState(initialTimestamp, initialSequenceId));
    }

    /**
     * 抽象方法：生成自增序列号
     * 子类实现具体的自增逻辑
     *
     * @param currentSeqId 当前序列号
     * @return 下一个序列号
     */
    protected abstract int generateSequenceId(int currentSeqId);

    /**
     * 抽象方法：获取子类定义的起始序列号
     * 子类可以重写该方法，提供自定义的初始值
     *
     * @return 子类指定的起始序列号
     */
    protected abstract int getInitialSequenceId();


    /**
     * 生成消息序号
     *
     * @return 长度为 12 字节的消息序号，分为三部分
     */
    @Override
    public SgipSequenceNumber generateSequence() {
        while (true) {
            // 获取当前状态
            SequenceState currentState = state.get();
            String currentTimestamp = getCurrentTimestamp();

            // 时间戳变化时，重置序列号
            if (!currentTimestamp.equals(currentState.timestamp)) {
                int initialSequenceId = getInitialSequenceId();
                SequenceState newState = new SequenceState(currentTimestamp, initialSequenceId);
                if (state.compareAndSet(currentState, newState)) {
                    return createSequence(newState, initialSequenceId);
                }
            } else {
                // 在同一时间戳下尝试分配序列号
                int currentSeqId = currentState.sequenceId;
                int nextSeqId = generateSequenceId(currentSeqId); // 使用子类的逻辑生成序列号

                if (nextSeqId >= 0) { // 有效序列号
                    SequenceState newState = new SequenceState(currentTimestamp, nextSeqId);
                    if (state.compareAndSet(currentState, newState)) {
                        return createSequence(currentState, nextSeqId);
                    }
                } else {
                    // 序列号无效，等待时间戳更新
                    try {
                        TimeUnit.MILLISECONDS.sleep(1); // 等待 1 毫秒
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /**
     * 构造消息序号
     */
    private SgipSequenceNumber createSequence(SequenceState state, int sequenceId) {
        int timestamp = Integer.parseInt(state.timestamp);
        return new DefaultSgipSequenceNumber(nodeId, timestamp, sequenceId);
    }

    /**
     * 获取当前时间戳，格式为 MMddHHmmss
     */
    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }

    /**
     * 内部类：保存时间戳和序列号状态
     */
    private static class SequenceState {
        final String timestamp; // 时间戳
        final int sequenceId;   // 当前序列号

        SequenceState(String timestamp, int sequenceId) {
            this.timestamp = timestamp;
            this.sequenceId = sequenceId;
        }
    }

}
