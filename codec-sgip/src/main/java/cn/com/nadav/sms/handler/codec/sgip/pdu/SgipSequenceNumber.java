package cn.com.nadav.sms.handler.codec.sgip.pdu;

public interface SgipSequenceNumber {

    int getNodeId();

    int getCurrentTimestamp();

    int getSequenceId();

    SgipSequenceNumber copy();

}
