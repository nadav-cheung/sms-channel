package cn.com.nadav.sms.handler.codec.sgip.pdu;

import cn.com.nadav.sms.handler.codec.sgip.SgipOpCode;

/**
 * sgip请求
 * method
 */
public interface SgipRequest extends SgipMessage {

    SgipOpCode getSgipOpCode();

    SgipRequest setSgipOpCode(SgipOpCode sgipOpCode);

    Object attachment();

    void setAttachment(Object attachment);

    int getCommandId();

    SgipSequenceNumber getSequenceNumber();

    SgipResponse getResponse();

}
