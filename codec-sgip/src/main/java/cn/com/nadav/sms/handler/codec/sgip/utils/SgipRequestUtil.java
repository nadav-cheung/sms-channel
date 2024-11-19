package cn.com.nadav.sms.handler.codec.sgip.utils;

import cn.com.nadav.sms.handler.codec.sgip.*;
import cn.com.nadav.sms.handler.codec.sgip.pdu.*;
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
        encodeHeader(request.header(), out);
        SgipOpCode sgipOpCode = request.getSgipOpCode();
        SgipContentCodec<SgipContent> codec = factory.getCodec(sgipOpCode);
        SgipContent sgipContent = request.sgipContent();
        codec.encodeSgipContent(sgipContent,out);
    }


    private static void encodeHeader(SgipHeader header, ByteBuf out) {
        out.writeInt(header.getCommandId());
        out.writeInt(header.getSequenceNumber().getNodeId());
        out.writeInt(header.getSequenceNumber().getCurrentTimestamp());
        out.writeInt(header.getSequenceNumber().getSequenceId());
    }


    private static SgipRequest newSgipMessageRequest(ByteBuf frame, SgipRequestFactory supplier) throws Exception {
        SgipHeader sgipHeader = decodeHeader(frame);
        SgipOpCode sgipOpCode = SgipOpCode.valueOf(sgipHeader.getCommandId());
        if (sgipOpCode == null) {
            throw new DecoderException("Unknown SGIP opcode: " + sgipHeader.getCommandId());
        }
        return supplier.newSgipRequest(sgipOpCode, sgipHeader);
    }


    private static SgipHeader decodeHeader(ByteBuf frame) {

        long messageLength = frame.readUnsignedInt();
        int commandId = frame.readInt();
        int nodeId = frame.readInt();
        int timestamp = frame.readInt();
        int sequenceId = frame.readInt();

        SgipHeader sgipHeader = new DefaultSgipHeader();
        sgipHeader.setMessageLength(messageLength);
        sgipHeader.setCommandId(commandId);
        SgipSequenceNumber sgipSequenceNumber = new DefaultSgipSequenceNumber(nodeId, timestamp, sequenceId);
        sgipHeader.setSequenceNumber(sgipSequenceNumber);
        return sgipHeader;
    }

}
