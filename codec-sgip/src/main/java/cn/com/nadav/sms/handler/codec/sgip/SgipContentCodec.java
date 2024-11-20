package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;

/**
 * Interface for encoding and decoding SGIP content.
 * This interface defines methods to convert between binary data in a ByteBuf
 * and a specific type of SGIP content object.
 *
 * @param <T> the type of SGIP content object that this codec handles
 */
public interface SgipContentCodec<T> {


    T decodeSgipContent(ByteBuf in) throws Exception;


    void encodeSgipContent(T msg, ByteBuf out);

}
