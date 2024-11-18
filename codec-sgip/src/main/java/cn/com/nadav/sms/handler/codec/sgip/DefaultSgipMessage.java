package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderResult;

public abstract class DefaultSgipMessage implements SgipMessage {

    private static final DecoderResult decoderResult = DecoderResult.SUCCESS;

    /**
     * A packet which is send or receive.
     */
    private ByteBuf content;

    private SgipHeader header;

    private SgipVersion version;


    public DefaultSgipMessage(SgipHeader header, SgipVersion version, ByteBuf content) {
        this.header = header;
        this.version = version;
        this.content = content;
    }


    public DefaultSgipMessage(SgipHeader header) {
        this(header, SgipVersion.SGIP_1_3, null);
    }


    public DefaultSgipMessage() {
        this(SgipHeaderFactory.newEmptyHeader(), SgipVersion.SGIP_1_3, null);
    }


    public ByteBuf getContent() {
        return content;
    }

    public void setContent(ByteBuf content) {
        this.content = content;
    }

    public SgipHeader getHeader() {
        return header;
    }

    @Override
    public SgipMessage setHeader(SgipHeader header) {
        this.header = header;
        return this;
    }

    public SgipVersion getVersion() {
        return version;
    }

    public void setVersion(SgipVersion version) {
        this.version = version;
    }
}
