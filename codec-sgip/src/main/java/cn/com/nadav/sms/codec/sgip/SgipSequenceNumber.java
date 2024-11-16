package cn.com.nadav.sms.codec.sgip;

public interface SgipSequenceNumber {

    int getNodeId();

    int getCurrentTimestamp();

    int getSequenceId();

}
