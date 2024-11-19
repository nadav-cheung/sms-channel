package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.handler.codec.DecoderResult;

public class DefaultSgipMessage implements SgipMessage {

    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    private SgipVersion version;

    private SgipHeader header;

    private SgipContent sgipContent;


    public DefaultSgipMessage(SgipHeader header, SgipVersion version) {
        this.header = header;
        this.version = version;
    }


    public DefaultSgipMessage(SgipHeader header) {
        this(header, SgipVersion.SGIP_1_3);
    }


    public DefaultSgipMessage() {
        this(new DefaultSgipHeader(), SgipVersion.SGIP_1_3);
    }


    public SgipHeader getHeader() {
        return this.header;
    }

    @Override
    public SgipVersion protocolVersion() {
        return this.version;
    }

    @Override
    public SgipMessage setProtocolVersion(SgipVersion protocolVersion) {
        this.version = protocolVersion;
        return this;
    }

    @Override
    public SgipHeader header() {
        return this.header;
    }

    @Override
    public SgipMessage setHeader(SgipHeader header) {
        this.header = header;
        return this;
    }

    @Override
    public SgipContent sgipContent() {
        return this.sgipContent;
    }

    @Override
    public SgipMessage setSgipContent(SgipContent sgipContent) {
        this.sgipContent = sgipContent;
        return this;
    }

    @Override
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override
    public void setDecoderResult(DecoderResult result) {
        this.decoderResult = result;
    }

}
