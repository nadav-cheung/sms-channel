package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipSequenceNumber;

/**
 * SequenceNumberGenerator is an interface responsible for generating SGIP (Short Message Gateway Interface Protocol)
 * sequence numbers. Implementations of this interface will provide the logic to generate the sequence numbers.
 */
public interface SequenceNumberGenerator {

    SgipSequenceNumber generateSequence();

}
