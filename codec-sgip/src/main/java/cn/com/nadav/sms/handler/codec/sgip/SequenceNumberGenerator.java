package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipSequenceNumber;

public interface SequenceNumberGenerator {

    SgipSequenceNumber generateSequence();

}
