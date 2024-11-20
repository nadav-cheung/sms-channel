package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipSequenceNumber;

/**
 * The DefaultSgipSequenceNumber class implements the SgipSequenceNumber interface.
 * This class represents a sequence number in an SGIP message, which consists of a node ID,
 * a timestamp, and a sequence ID.
 */
public class DefaultSgipSequenceNumber implements SgipSequenceNumber {

    private final int nodeId;

    private final int currentTimestamp;

    private final int sequenceId;

    public DefaultSgipSequenceNumber(int nodeId, int currentTimestamp, int sequenceId) {
        this.nodeId = nodeId;
        this.currentTimestamp = currentTimestamp;
        this.sequenceId = sequenceId;
    }


    @Override
    public int getNodeId() {
        return nodeId;
    }

    @Override
    public int getCurrentTimestamp() {
        return currentTimestamp;
    }

    @Override
    public int getSequenceId() {
        return sequenceId;
    }


    @Override
    public SgipSequenceNumber copy() {
        return new DefaultSgipSequenceNumber(nodeId, currentTimestamp, sequenceId);
    }


}
