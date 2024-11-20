package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.DefaultSgipRequest;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipHeader;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipRequest;
import cn.com.nadav.sms.handler.codec.sgip.utils.SgipRequestUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * The SgipRequestDecoder class extends the LengthFieldBasedFrameDecoder and is responsible for
 * decoding incoming SGIP (Short Message Gateway Interface Protocol) request frames.
 * It utilizes the SgipContentCodecFactory to decode the content of the SGIP messages.
 */
public class SgipRequestDecoder extends LengthFieldBasedFrameDecoder {

    /**
     * A static final instance of the SgipContentCodecFactory used for creating and managing SGIP content codecs.
     * This factory provides a centralized way to retrieve the appropriate codec for encoding or decoding SGIP messages
     * based on the SGIP operation codes.
     */
    public static final SgipContentCodecFactory factory = SgipContentCodecFactory.getInstance();


    public SgipRequestDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        // 一个完整的frame
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        if (frame == null) {
            return null;
        }

        return SgipRequestUtil.decodeSgipRequest(factory, frame.slice(),
                new SgipRequestUtil.SgipRequestFactory() {
                    @Override
                    public SgipRequest newSgipRequest(SgipOpCode sgipOpCode, SgipHeader sgipHeader) {
                        return new DefaultSgipRequest(sgipHeader);
                    }
                });
    }


}
