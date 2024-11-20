package cn.com.nadav.sms.handler.codec.sgip;

/**
 * A simple implementation of the AbstractSequenceNumberGenerator that generates
 * sequential numbers starting from 0.
 */
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
