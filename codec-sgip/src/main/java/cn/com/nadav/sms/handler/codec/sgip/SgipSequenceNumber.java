package cn.com.nadav.sms.handler.codec.sgip;

public interface SgipSequenceNumber {

    int getNodeId();

    int getCurrentTimestamp();

    int getSequenceId();

}
