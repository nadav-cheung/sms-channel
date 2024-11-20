package cn.com.nadav.sms.handler.codec.sgip.utils;

import cn.com.nadav.sms.handler.codec.sgip.DefaultSgipSequenceNumber;
import cn.com.nadav.sms.handler.codec.sgip.pdu.DefaultSgipHeader;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipHeader;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipSequenceNumber;
import io.netty.buffer.ByteBuf;

/**
 * Utility class for encoding and decoding SGIP (Short Message Gateway Interface Protocol) headers.
 * This class provides methods to convert SGIP headers to and from a byte buffer representation.
 */
public class SgipHeaderUtil {

    public static void encodeHeader(SgipHeader header, ByteBuf out) {
        // totalLength 最后计算
        out.writeInt(header.getCommandId());
        out.writeInt(header.getSequenceNumber().getNodeId());
        out.writeInt(header.getSequenceNumber().getCurrentTimestamp());
        out.writeInt(header.getSequenceNumber().getSequenceId());
    }

    public static SgipHeader decodeHeader(ByteBuf frame) {

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
