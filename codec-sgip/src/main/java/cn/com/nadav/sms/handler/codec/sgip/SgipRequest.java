package cn.com.nadav.sms.handler.codec.sgip;

public interface SgipRequest extends SgipMessage {

    SgipMethod getSgipMethod();

    Object attachment();

    void setAttachment(Object attachment);

    int getCommandId();

    SgipMessage setCommandId(int commandId);

    SgipMessage setSgipMethod(SgipMethod sgipMethod);


}
