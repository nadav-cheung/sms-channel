package cn.com.nadav.sms.handler.codec.sgip.pdu;

import cn.com.nadav.sms.handler.codec.sgip.SgipOpCode;
import io.netty.handler.codec.DecoderResultProvider;

/**
 * Interface representing an SGIP (Short Message Gateway Interface Protocol) message.
 * Provides methods to access and modify the header and content of the message.
 * Also allows retrieval of the operation code specific to the SGIP protocol.
 */
public interface SgipMessage extends DecoderResultProvider {

    SgipHeader header();

    SgipMessage setHeader(SgipHeader header);

    SgipContent sgipContent();

    SgipMessage setSgipContent(SgipContent sgipContent);

    SgipOpCode getSgipOpCode();

}
