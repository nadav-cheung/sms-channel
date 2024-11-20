package cn.com.nadav.sms.handler.codec.sgip.pdu;

/**
 * Interface defining the structure of an SGIP (Short Message Gateway Interface Protocol) header.
 * This interface contains methods to manipulate and access the properties of the SGIP header,
 * including message length, command ID, sequence number, and header length.
 */
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
