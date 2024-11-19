package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.handler.codec.DecoderResult;

public abstract class AbstractSgipContent implements SgipContent {

    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    public AbstractSgipContent() {
    }

    @Override
    public DecoderResult decoderResult() {
        return decoderResult;
    }

    public void setDecoderResult(DecoderResult result) {
        this.decoderResult = result;
    }


}
