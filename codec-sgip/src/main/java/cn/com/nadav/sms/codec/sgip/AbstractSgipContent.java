package cn.com.nadav.sms.codec.sgip;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderResult;

public abstract class AbstractSgipContent implements SgipContent {


    private final ByteBuf content;

    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    public AbstractSgipContent(ByteBuf content) {
        this.content = content;
    }

    @Override
    public DecoderResult decoderResult() {
        return decoderResult;
    }

    public void setDecoderResult(DecoderResult result) {
        this.decoderResult = result;
    }

    @Override
    public ByteBuf content() {
        return content;
    }

    @Override
    public SgipContent retain() {
        content.retain();
        return this;
    }

    @Override
    public SgipContent touch() {
        content.touch();
        return this;
    }

    @Override
    public int refCnt() {
        return content.refCnt();
    }

    @Override
    public boolean release() {
        return content.release();
    }

    @Override
    public boolean release(int decrement) {
        return content.release(decrement);
    }


}
