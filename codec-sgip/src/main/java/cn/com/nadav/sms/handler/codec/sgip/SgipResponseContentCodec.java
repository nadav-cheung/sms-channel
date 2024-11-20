package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipResponseContent;
import cn.com.nadav.sms.handler.codec.sgip.utils.FixedLengthTextCodecUtil;
import io.netty.buffer.ByteBuf;

/**
 * A codec for encoding and decoding SGIP (Short Message Gateway Interface Protocol) response contents.
 * This class implements the SgipContentCodec interface for the SgipResponseContent type.
 */
public class SgipResponseContentCodec implements SgipContentCodec<SgipResponseContent> {


    @Override
    public SgipResponseContent decodeSgipContent(ByteBuf in) throws Exception {

        // 检查是否有足够数据

        // 读取结果
        int result = in.readByte();
        // 读取 Reserve
        String reserve = FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.RESERVE_LENGTH);


        // 构造 LoginMessage 对象并添加到输出列表
        return new SgipResponseContent(result, reserve);

    }

    @Override
    public void encodeSgipContent(SgipResponseContent msg, ByteBuf out) {
        // 写入 Login Type
        out.writeByte(msg.getResult());

        // 写入 Reserve
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getReserve(), SgipConstants.RESERVE_LENGTH);
    }


}
