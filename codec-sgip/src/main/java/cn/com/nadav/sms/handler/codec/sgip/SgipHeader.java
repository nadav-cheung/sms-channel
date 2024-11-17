package cn.com.nadav.sms.handler.codec.sgip;

public interface SgipHeader {

    int getMessageLength();

    void setMessageLength(int messageLength);

    int getCommandId();

    void setCommandId(int commandId);

    SgipSequenceNumber getSequenceNumber();

    void setSequenceNumber(SgipSequenceNumber sequenceNumber);

    int getHeaderLength();

}
