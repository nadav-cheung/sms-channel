package cn.com.nadav.sms.handler.codec.sgip.pdu;

import io.netty.handler.codec.DecoderResultProvider;

/**
 * sgipMessage
 * version
 * header
 */
public interface SgipMessage extends DecoderResultProvider {

    SgipHeader header();

    SgipMessage setHeader(SgipHeader header);

    SgipContent sgipContent();

    SgipMessage setSgipContent(SgipContent sgipContent);

}
