package cn.com.nadav.sms.handler.codec.sgip.utils;

import cn.com.nadav.sms.handler.codec.sgip.SgipContentCodec;
import cn.com.nadav.sms.handler.codec.sgip.SgipContentCodecFactory;
import cn.com.nadav.sms.handler.codec.sgip.SgipOpCode;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipContent;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipHeader;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipResponse;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;

public class SgipResponseUtil {


    public static SgipResponse decodeSgipResponse(SgipContentCodecFactory factory, ByteBuf buf, SgipResponseFactory supplier) throws Exception {
        SgipResponse response = newSgipMessageRequest(buf, supplier);
        SgipContentCodec<SgipContent> codec = factory.getCodec(response.getSgipOpCode());
        SgipContent sgipContent = codec.decodeSgipContent(buf);
        response.setSgipContent(sgipContent);
        return response;
    }

    private static SgipResponse newSgipMessageRequest(ByteBuf frame, SgipResponseFactory supplier) throws Exception {
        SgipHeader sgipHeader = SgipHeaderUtil.decodeHeader(frame);
        SgipOpCode sgipOpCode = SgipOpCode.valueOf(sgipHeader.getCommandId());
        if (sgipOpCode == null) {
            throw new DecoderException("Unknown SGIP opcode: " + sgipHeader.getCommandId());
        }
        return supplier.newSgipResponse(sgipOpCode, sgipHeader);
    }

    public interface SgipResponseFactory {
        SgipResponse newSgipResponse(SgipOpCode sgipOpCode, SgipHeader sgipHeader);
    }

}
