package cn.com.nadav.sms.handler.codec.sgip.pdu;

import io.netty.handler.codec.DecoderResult;

/**
 * Abstract base class for SGIP content. This class provides a common implementation
 * for handling the decoder result, and serves as a foundation for more specific
 * SGIP content types.
 */
public abstract class AbstractSgipContent implements SgipContent {

    private DecoderResult decoderResult = initializeDecoderResult();

    public AbstractSgipContent() {
    }

    @Override
    public DecoderResult decoderResult() {
        return decoderResult;
    }

    public void setDecoderResult(DecoderResult result) {
        this.decoderResult = result;
    }

    private DecoderResult initializeDecoderResult() {
        return DecoderResult.SUCCESS;
    }
}
