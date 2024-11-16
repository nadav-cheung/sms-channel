package cn.com.nadav.sms.codec.sgip;

public class SimpleSequenceNumberGenerator extends AbstractSequenceNumberGenerator {


    public SimpleSequenceNumberGenerator(int nodeId) {
        super(nodeId);
    }

    @Override
    protected int generateSequenceId(int currentSeqId) {
        return currentSeqId + 1;
    }

    @Override
    protected int getInitialSequenceId() {
        return 0;
    }

}
