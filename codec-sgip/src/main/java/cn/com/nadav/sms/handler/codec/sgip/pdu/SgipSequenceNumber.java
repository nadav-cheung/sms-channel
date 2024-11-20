package cn.com.nadav.sms.handler.codec.sgip.pdu;

/**
 * Interface representing the sequence number in an SGIP (Short Message Gateway Interface Protocol) message.
 * This sequence number is composed of a node ID, a timestamp, and a sequence ID.
 */
public interface SgipSequenceNumber {

    int getNodeId();

    int getCurrentTimestamp();

    int getSequenceId();

    SgipSequenceNumber copy();

}
