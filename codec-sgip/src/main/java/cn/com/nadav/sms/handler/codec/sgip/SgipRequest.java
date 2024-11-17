package cn.com.nadav.sms.handler.codec.sgip;

public interface SgipRequest<T> extends SgipMessage {

    T sgipContent();

}
