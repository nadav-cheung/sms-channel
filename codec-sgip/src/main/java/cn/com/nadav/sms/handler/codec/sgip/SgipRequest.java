package cn.com.nadav.sms.handler.codec.sgip;

/**
 * sgip请求
 * method
 *
 */
public interface SgipRequest extends SgipMessage {

    SgipOpCode getSgipOpCode();

    SgipRequest setSgipMethod(SgipOpCode sgipOpCode);

    Object attachment();

    void setAttachment(Object attachment);

    int getCommandId();

    SgipRequest setCommandId(int commandId);



}
