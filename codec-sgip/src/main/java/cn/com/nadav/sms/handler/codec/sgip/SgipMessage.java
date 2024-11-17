package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.handler.codec.DecoderResultProvider;

public interface SgipMessage extends DecoderResultProvider {

    SgipVersion protocolVersion();

    SgipMessage setProtocolVersion(SgipVersion protocolVersion);

    SgipHeader header();

    SgipMessage setHeader(SgipHeader header);

    int getCommandId();

    SgipMessage setCommandId(int commandId);

    Object attachment();

    void setAttachment(Object attachment);


}
