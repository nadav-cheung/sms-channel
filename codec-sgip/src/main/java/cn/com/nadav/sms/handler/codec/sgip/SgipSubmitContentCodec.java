package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipSubmitContent;
import cn.com.nadav.sms.handler.codec.sgip.utils.FixedLengthTextCodecUtil;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SgipSubmitContentCodec implements SgipContentCodec<SgipSubmitContent> {

    @Override
    public SgipSubmitContent decodeSgipContent(ByteBuf in) throws Exception {
        SgipSubmitContent content = new SgipSubmitContent();
        content.setSpNumber(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_SP_NUMBER_LEN));
        content.setChargeNumber(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_CHARGE_NUMBER_LEN));
        content.setUserCount(in.readByte());
        readUserNumbers(content, in);
        content.setCorpId(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_CORP_ID_LEN));
        content.setServiceType(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_SERVICE_TYPE_LEN));
        content.setFeeType(in.readByte());
        content.setFeeValue(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_FEE_VALUE_LEN));
        content.setGivenValue(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_GIVEN_VALUE_LEN));
        content.setAgentFlag(in.readByte());
        content.setMorelatetoMTFlag(in.readByte());
        content.setPriority(in.readByte());
        content.setExpireTime(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_EXPIRE_TIME_LEN));
        content.setScheduleTime(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_SCHEDULE_TIME_LEN));
        content.setReportFlag(in.readByte());
        content.setMessageType(in.readByte());
        content.setTpPid(in.readByte());
        content.setTpUdhi(in.readByte());
        content.setMessageCoding(in.readByte());
        content.setMessageType(in.readByte());
        content.setMessageLength(in.readInt());
        content.setMessageContent(FixedLengthTextCodecUtil.readFixedLengthString(in, content.getMessageLength()));
        content.setReserve(FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_RESERVE_LEN));
        return content;
    }


    private void readUserNumbers(SgipSubmitContent content, ByteBuf in) {
        int userCount = in.readByte();
        List<String> userNumberList = IntStream
                .range(0, userCount)
                .mapToObj(i -> FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_USER_NUMBER_LEN))
                .collect(Collectors.toCollection(() -> new ArrayList<>(userCount)));
        content.setUserNumbers(userNumberList);
    }

    private void writeUserNumbers(SgipSubmitContent content, ByteBuf in) {
        int userCount = in.readByte();
        List<String> userNumberList = IntStream
                .range(0, userCount)
                .mapToObj(i -> FixedLengthTextCodecUtil.readFixedLengthString(in, SgipConstants.SUBMIT_USER_NUMBER_LEN))
                .collect(Collectors.toCollection(() -> new ArrayList<>(userCount)));
        content.setUserNumbers(userNumberList);
    }


    @Override
    public void encodeSgipContent(SgipSubmitContent msg, ByteBuf out) {

        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getSpNumber(), SgipConstants.SUBMIT_SP_NUMBER_LEN);
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getChargeNumber(), SgipConstants.SUBMIT_CHARGE_NUMBER_LEN);
        out.writeByte(msg.getUserCount());
        writeUserNumbers(msg, out);
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getCorpId(), SgipConstants.SUBMIT_CORP_ID_LEN);
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getServiceType(), SgipConstants.SUBMIT_SERVICE_TYPE_LEN);
        out.writeByte(msg.getFeeType());

        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getFeeValue(), SgipConstants.SUBMIT_FEE_VALUE_LEN);
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getGivenValue(), SgipConstants.SUBMIT_GIVEN_VALUE_LEN);
        out.writeByte(msg.getAgentFlag());
        out.writeByte(msg.getMorelatetoMTFlag());
        out.writeByte(msg.getPriority());

        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getExpireTime(), SgipConstants.SUBMIT_EXPIRE_TIME_LEN);
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getScheduleTime(), SgipConstants.SUBMIT_SCHEDULE_TIME_LEN);


        out.writeByte(msg.getReportFlag());
        out.writeByte(msg.getMessageType());
        out.writeByte(msg.getTpPid());
        out.writeByte(msg.getTpUdhi());
        out.writeByte(msg.getMessageCoding());
        out.writeByte(msg.getMessageType());
        out.writeInt(msg.getMessageLength());
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getMessageContent(), msg.getMessageLength());
        FixedLengthTextCodecUtil.writeFixedLengthString(out, msg.getReserve(), SgipConstants.SUBMIT_RESERVE_LEN);
    }
}
