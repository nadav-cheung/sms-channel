package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.DecoderResultProvider;

public interface SgipMessage extends DecoderResultProvider, ByteBufHolder {

    SgipVersion protocolVersion();

    SgipMessage setProtocolVersion(SgipVersion protocolVersion);

    SgipHeader header();

    SgipMessage setHeader(SgipHeader header);

    SgipContent sgipContent();

}
