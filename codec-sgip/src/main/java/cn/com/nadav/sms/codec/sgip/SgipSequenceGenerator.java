package cn.com.nadav.sms.codec.sgip;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 通过时间戳区分：
 * <p>
 * 当自增序列到达上限（0xFFFFFFFF）时，生成新序列号时依赖于下一个时间戳的变化，从而避免重复。
 * 每秒的时间戳部分会变化，因此即使序列号从零开始，也不会与之前的序号重复。
 * 自增序列限制与检测：
 * <p>
 * 当时间戳未变化并且序列号已经到达最大值时，可以强制等待时间或抛出异常，避免生成重复的序列。
 */
public class SgipSequenceGenerator {

    private final int nodeId; // 命令源节点编号

    private final int maxSequence = 0xFFFFFFFF; // 自增序列的最大值

    // 保存时间戳和当前序列号范围的状态
    private final AtomicReference<SequenceState> state;

    public SgipSequenceGenerator(int nodeId) {
        this.nodeId = nodeId;
        String initialTimestamp = getCurrentTimestamp();
        this.state = new AtomicReference<>(new SequenceState(initialTimestamp, 0));
    }

    /**
     * 生成消息序号
     *
     * @return 长度为12字节的消息序号，分为三部分
     */
    public long[] generateSequence() {
        while (true) {
            // 获取当前状态
            SequenceState currentState = state.get();
            String currentTimestamp = getCurrentTimestamp();

            // 时间戳变化时，重置序列号
            if (!currentTimestamp.equals(currentState.timestamp)) {
                SequenceState newState = new SequenceState(currentTimestamp, 0);
                if (state.compareAndSet(currentState, newState)) {
                    // 更新成功后生成序列号
                    return createSequence(newState, 0);
                }
            } else {
                // 在同一时间戳下尝试分配序列号
                int currentSeqId = currentState.sequenceId;
                if (currentSeqId < maxSequence) {
                    SequenceState newState = new SequenceState(currentTimestamp, currentSeqId + 1);
                    if (state.compareAndSet(currentState, newState)) {
                        return createSequence(currentState, currentSeqId);
                    }
                } else {
                    // 自增序列已满，等待时间戳更新
                    try {
                        Thread.sleep(1); // 等待1毫秒以推进时间
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
    private long[] createSequence(SequenceState state, int sequenceId) {
        long part1 = nodeId & 0xFFFFFFFFL;
        long part2 = Long.parseLong(state.timestamp);
        long part3 = sequenceId & 0xFFFFFFFFL;
        return new long[]{part1, part2, part3};
    }

    /**
     * 获取当前时间戳，格式为MMddHHmmss
     */
    private String getCurrentTimestamp() {
        return new SimpleDateFormat("MMddHHmmss").format(new Date());
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

    public static void main(String[] args) {
        // 示例：节点编号为12345
        SgipSequenceGenerator generator = new SgipSequenceGenerator(12345);

        // 多线程测试生成序号
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                long[] sequence = generator.generateSequence();
                System.out.printf("Thread-%s Sequence: [%d, %d, %d]%n",
                        Thread.currentThread().getName(), sequence[0], sequence[1], sequence[2]);
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        t1.start();
        t2.start();
    }

}
