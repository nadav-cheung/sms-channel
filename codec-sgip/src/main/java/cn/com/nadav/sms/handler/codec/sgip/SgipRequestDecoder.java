package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.DefaultSgipRequest;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipHeader;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipRequest;
import cn.com.nadav.sms.handler.codec.sgip.utils.SgipRequestUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class SgipRequestDecoder extends LengthFieldBasedFrameDecoder {

    public static final SgipContentCodecFactory factory = SgipContentCodecFactory.INSTANCE;


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
                        return new DefaultSgipRequest(sgipHeader, sgipOpCode);
                    }
                });
    }


}
