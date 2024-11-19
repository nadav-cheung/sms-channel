package cn.com.nadav.sms.handler.codec.sgip.pdu;

import io.netty.handler.codec.DecoderResult;

public class DefaultSgipMessage implements SgipMessage {

    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    private SgipHeader header;

    private SgipContent sgipContent;


    public DefaultSgipMessage(SgipHeader header) {
        this.header = header;
    }


    public DefaultSgipMessage() {
        this(new DefaultSgipHeader());
    }


    public SgipHeader getHeader() {
        return this.header;
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
