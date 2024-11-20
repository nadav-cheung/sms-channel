package cn.com.nadav.sms.handler.codec.sgip.pdu;

/**
 * This class represents a default implementation of an SGIP response message.
 * It extends the capabilities of the DefaultSgipMessage class and implements
 * the SgipResponse interface, providing the necessary structure for SGIP
 * response operations.
 */
public class DefaultSgipResponse extends DefaultSgipMessage implements SgipResponse {


    public DefaultSgipResponse(SgipHeader header) {
        super(header);
    }


}
