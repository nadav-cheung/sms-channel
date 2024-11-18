package cn.com.nadav.sms.handler.codec.sgip;

/**
 * 保证分部署场景下唯一
 */
public class DatacenterMachineSequenceNumberGenerator extends AbstractSequenceNumberGenerator {

    private static final int MAX_MACHINE_ID = 15; // 机器 ID 最大值 (4 位)

    private static final int MAX_DATACENTER_ID = 15; // 数据中心 ID 最大值 (4 位)

    private final int machineId; // 当前机器 ID

    private final int dataCenterId; // 数据中心 ID

    // 递增步长（根据数据中心ID和机器ID生成）
    private final int stepIncrement;


    public DatacenterMachineSequenceNumberGenerator(int dataCenterId,
                                                    int machineId,
                                                    int nodeId) {
        super(nodeId);
        if (dataCenterId < 0 || dataCenterId > MAX_DATACENTER_ID) {
            throw new IllegalArgumentException("Data Center ID must be between 0 and " + MAX_DATACENTER_ID);
        }
        if (machineId < 0 || machineId > MAX_MACHINE_ID) {
            throw new IllegalArgumentException("Machine ID must be between 0 and " + MAX_MACHINE_ID);
        }

        this.dataCenterId = dataCenterId;
        this.machineId = machineId;

        this.stepIncrement = (dataCenterId << 8) | machineId; // 根据数据中心和机器ID生成递增步长

    }

    @Override
    protected int generateSequenceId(int currentSeqId) {
        return currentSeqId + stepIncrement;
    }

    @Override
    protected int getInitialSequenceId() {
        return 0;
    }

}
