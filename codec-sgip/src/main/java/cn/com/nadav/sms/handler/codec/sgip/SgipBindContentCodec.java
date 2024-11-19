package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipBindContent;
import cn.com.nadav.sms.handler.codec.sgip.utils.FixedLengthTextCodecUtil;
import io.netty.buffer.ByteBuf;

public class SgipBindContentCodec implements SgipContentCodec<SgipBindContent> {


    @Override
    public SgipBindContent decodeSgipContent(ByteBuf in) throws Exception {
        // 检查是否有足够数据
        if (in.readableBytes() < SgipConstants.BIND_TOTAL_MESSAGE_LENGTH) {
            return null;
        }

        // 读取 Login Type
        int loginType = in.readInt();

        // 读取 Login Name
        String loginName = FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.BIND_NAME_LENGTH);

        // 读取 Login Password
        String loginPassword = FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.BIND_PASSWORD_LENGTH);

        // 读取 Reserve
        String reserve = FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.RESERVE_LENGTH);


        // 构造 LoginMessage 对象并添加到输出列表
        return new SgipBindContent(loginType, loginName, loginPassword, reserve);
    }

    @Override
    public void encodeSgipContent(SgipBindContent msg, ByteBuf out) {
        // 写入 Login Type
        out.writeInt(msg.getLoginType());

        // 写入 Login Name
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getLoginName(), SgipConstants.BIND_NAME_LENGTH);

        // 写入 Login Password
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getPassword(), SgipConstants.BIND_PASSWORD_LENGTH);

        // 写入 Reserve
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getReserve(), SgipConstants.RESERVE_LENGTH);
    }

}
