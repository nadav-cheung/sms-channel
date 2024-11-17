package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.DefaultByteBufHolder;
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


    @Override
    public ByteBufHolder copy() {
        return replace(content.copy());
    }

    @Override
    public ByteBufHolder duplicate() {
        return replace(content.duplicate());
    }

    @Override
    public ByteBufHolder retainedDuplicate() {
        return replace(content.retainedDuplicate());
    }

    @Override
    public ByteBufHolder replace(ByteBuf content) {
        return new DefaultByteBufHolder(content);
    }

    @Override
    public ByteBufHolder retain(int increment) {
        return replace(content.retain());
    }

    @Override
    public ByteBufHolder touch(Object hint) {
        return replace(content.touch());
    }
}
