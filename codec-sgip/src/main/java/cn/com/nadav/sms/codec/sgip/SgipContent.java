package cn.com.nadav.sms.codec.sgip;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;

public interface SgipContent extends DecoderResultProvider, ByteBufHolder {

    /**
     * Provides the DecoderResult which can represent success or failure of decoding.
     * This can be useful for checking if a message was decoded successfully.
     *
     * @return the DecoderResult of the content.
     */
    @Override
    DecoderResult decoderResult();

    /**
     * Gets the content of the message as a ByteBuf.
     * This would typically be the raw message body.
     *
     * @return the ByteBuf holding the content.
     */
    @Override
    ByteBuf content();

    /**
     * Retains the content reference count for proper resource management.
     * This method is inherited from ByteBufHolder.
     *
     * @return the retained ByteBufHolder.
     */
    @Override
    SgipContent retain();


}
