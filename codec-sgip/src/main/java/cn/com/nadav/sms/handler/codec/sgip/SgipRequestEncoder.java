package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipRequest;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class SgipRequestEncoder extends MessageToByteEncoder<SgipRequest> {

    @Override
    protected void encode(ChannelHandlerContext ctx, SgipRequest msg, ByteBuf out) throws Exception {

        // 预留4个字节写入消息长度
        out.writerIndex(out.writerIndex() + 4);
        encoder.encode(msg, out);

        // Now fill in the correct length based on the amount of data that we wrote the ByteBuf.
        out.setInt(0, out.readableBytes());
    }
}
