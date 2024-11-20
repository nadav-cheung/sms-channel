package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.DefaultSgipResponse;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipHeader;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipResponse;
import cn.com.nadav.sms.handler.codec.sgip.utils.SgipResponseUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * A decoder for SGIP (Short Message Gateway Interface Protocol) responses.
 * This class extends the LengthFieldBasedFrameDecoder to handle decoding of SGIP responses
 * from a ByteBuf. It uses an SgipContentCodecFactory to retrieve the appropriate codec for decoding
 * the SGIP content.
 */
public class SgipResponseDecoder extends LengthFieldBasedFrameDecoder {

    public static final SgipContentCodecFactory factory = SgipContentCodecFactory.getInstance();


    public SgipResponseDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        // 一个完整的frame
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);

        if (frame == null) {
            return null;
        }

        return SgipResponseUtil.decodeSgipResponse(factory, frame.slice(), new SgipResponseUtil.SgipResponseFactory() {
            @Override
            public SgipResponse newSgipResponse(SgipOpCode sgipOpCode, SgipHeader sgipHeader) {
                return new DefaultSgipResponse(sgipHeader);
            }
        });
    }


}
