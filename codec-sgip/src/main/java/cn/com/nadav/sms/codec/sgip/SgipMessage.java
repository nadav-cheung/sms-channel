package cn.com.nadav.sms.codec.sgip;

import io.netty.handler.codec.DecoderResultProvider;

public interface SgipMessage extends DecoderResultProvider {


    /**
     * Re
     * @return
     */
    SgipVersion protocolVersion();

    SgipMessage setProtocolVersion(SgipVersion protocolVersion);

    SgipHeader header();



}
