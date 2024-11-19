package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;

public interface SgipContentCodec<T> {


    T decodeSgipContent(ByteBuf in) throws Exception;


    void encodeSgipContent(T msg, ByteBuf out);

}
