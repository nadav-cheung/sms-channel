package cn.com.nadav.sms.codec.sgip;

public interface SgipHeader {

    int getMessageLength();

    void setMessageLength(int messageLength);

    int getCommandId();

    void setCommandId(int commandId);

    int getSequenceNumber();

    void setSequenceNumber(int sequenceNumber);


}
