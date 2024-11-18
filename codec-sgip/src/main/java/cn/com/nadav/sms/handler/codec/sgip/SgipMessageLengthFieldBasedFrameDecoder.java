package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class SgipMessageLengthFieldBasedFrameDecoder extends LengthFieldBasedFrameDecoder {


    private final DnsRecordDecoder decoder;

    public SgipMessageLengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        // 一个完整的frame
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);

        if (frame == null) {
            return null;
        }

        // 将一个完整的消息帧解码成消息

        SgipMessageResponse sgipMessageResponse;


    }


}
