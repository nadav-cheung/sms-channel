package cn.com.nadav.sms.handler.codec.sgip.pdu;

import io.netty.handler.codec.DecoderResultProvider;

/**
 * Represents the content part of an SGIP (Short Message Gateway Interface Protocol) message.
 * This interface extends DecoderResultProvider to handle the result of the decoding process.
 * Implementations of this interface will define specific content structures for various types of SGIP messages.
 */
public interface SgipContent extends DecoderResultProvider {

    Class<? extends SgipContent> getContentType();

}
