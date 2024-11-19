package cn.com.nadav.sms.handler.codec.sgip.pdu;

public interface SgipHeader {

    long getMessageLength();

    void setMessageLength(long messageLength);

    int getCommandId();

    void setCommandId(int commandId);

    SgipSequenceNumber getSequenceNumber();

    void setSequenceNumber(SgipSequenceNumber sequenceNumber);

    int getHeaderLength();

    void setHeaderLength(int headerLength);

    long getContentLength();


}
