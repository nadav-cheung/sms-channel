package cn.com.nadav.sms.handler.codec.sgip.pdu;

import cn.com.nadav.sms.handler.codec.sgip.SgipOpCode;

/**
 * This interface represents an SGIP (Short Message Gateway Interface Protocol) Request.
 * Extends the SgipMessage interface and provides additional methods specific to SGIP requests.
 */
public interface SgipRequest extends SgipMessage {

    Object attachment();

    void setAttachment(Object attachment);

    int getCommandId();

    SgipSequenceNumber getSequenceNumber();

    SgipResponse getResponse();

    SgipOpCode getSgipOpCode();

}
