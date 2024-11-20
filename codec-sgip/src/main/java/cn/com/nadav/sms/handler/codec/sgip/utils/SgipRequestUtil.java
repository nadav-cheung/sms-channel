package cn.com.nadav.sms.handler.codec.sgip.utils;

import cn.com.nadav.sms.handler.codec.sgip.SgipContentCodec;
import cn.com.nadav.sms.handler.codec.sgip.SgipContentCodecFactory;
import cn.com.nadav.sms.handler.codec.sgip.SgipOpCode;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipContent;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipHeader;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipRequest;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;

public class SgipRequestUtil {


    public static SgipRequest decodeSgipRequest(SgipContentCodecFactory factory, ByteBuf buf, SgipRequestFactory supplier) throws Exception {
        SgipRequest sgipRequest = newSgipMessageRequest(buf, supplier);
        SgipContentCodec<SgipContent> codec = factory.getCodec(sgipRequest.getSgipOpCode());
        SgipContent sgipContent = codec.decodeSgipContent(buf);
        sgipRequest.setSgipContent(sgipContent);
        return sgipRequest;
    }


    public interface SgipRequestFactory {
        SgipRequest newSgipRequest(SgipOpCode sgipOpCode, SgipHeader sgipHeader);
    }


    public static void encodeSgipRequest(SgipContentCodecFactory factory, SgipRequest request, ByteBuf out) throws Exception {
        SgipHeaderUtil.encodeHeader(request.header(), out);
        SgipOpCode sgipOpCode = request.getSgipOpCode();
        SgipContentCodec<SgipContent> codec = factory.getCodec(sgipOpCode);
        SgipContent sgipContent = request.sgipContent();
        codec.encodeSgipContent(sgipContent, out);
    }


    private static SgipRequest newSgipMessageRequest(ByteBuf frame, SgipRequestFactory supplier) throws Exception {
        SgipHeader sgipHeader = SgipHeaderUtil.decodeHeader(frame);
        SgipOpCode sgipOpCode = SgipOpCode.valueOf(sgipHeader.getCommandId());
        if (sgipOpCode == null) {
            throw new DecoderException("Unknown SGIP opcode: " + sgipHeader.getCommandId());
        }
        return supplier.newSgipRequest(sgipOpCode, sgipHeader);
    }


}
