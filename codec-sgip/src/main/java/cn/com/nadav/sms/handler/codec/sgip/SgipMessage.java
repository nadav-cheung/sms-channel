package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.handler.codec.DecoderResultProvider;

/**
 * sgipMessage
 * version
 * header
 */
public interface SgipMessage extends DecoderResultProvider {

    SgipVersion protocolVersion();

    SgipMessage setProtocolVersion(SgipVersion protocolVersion);

    SgipHeader header();

    SgipMessage setHeader(SgipHeader header);

    SgipContent sgipContent();

    SgipMessage setSgipContent(SgipContent sgipContent);

}
