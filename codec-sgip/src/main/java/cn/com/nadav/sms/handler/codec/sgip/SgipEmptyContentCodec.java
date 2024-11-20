package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipEmptyContent;
import io.netty.buffer.ByteBuf;

public class SgipEmptyContentCodec implements SgipContentCodec<SgipEmptyContent> {


    @Override
    public SgipEmptyContent decodeSgipContent(ByteBuf in) throws Exception {

        if (in.readableBytes() > 0) {
            in.skipBytes(in.readableBytes());
        }

        // 构造 LoginMessage 对象并添加到输出列表
        return new SgipEmptyContent();
    }

    @Override
    public void encodeSgipContent(SgipEmptyContent msg, ByteBuf out) {
        // do nothing
    }

}
