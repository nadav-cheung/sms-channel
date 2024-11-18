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


}
