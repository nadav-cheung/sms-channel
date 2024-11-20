package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipRequest;
import cn.com.nadav.sms.handler.codec.sgip.utils.SgipRequestUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Encodes an SGIP (Short Message Gateway Interface Protocol) request into a ByteBuf.
 * The encoded message includes a 4-byte length prefix followed by the SGIP request content.
 * This class extends the Netty framework's `MessageToByteEncoder` to provide encoding functionality for SGIP requests.
 */
public class SgipRequestEncoder extends MessageToByteEncoder<SgipRequest> {

    public static final SgipContentCodecFactory factory = SgipContentCodecFactory.getInstance();


    @Override
    protected void encode(ChannelHandlerContext ctx, SgipRequest msg, ByteBuf out) throws Exception {

        // 预留4个字节写入消息长度
        out.writerIndex(out.writerIndex() + 4);

        SgipRequestUtil.encodeSgipRequest(factory, msg, out);

        // Now fill in the correct length based on the amount of data that we wrote the ByteBuf.
        out.setInt(0, out.readableBytes());
    }
}
