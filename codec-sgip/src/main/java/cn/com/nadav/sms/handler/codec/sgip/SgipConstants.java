package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * Class holding constant values related to SGIP (Short Message Gateway Interface Protocol).
 */
public class SgipConstants {


    /**
     * Default character set (UTF-8)
     */
    public static final Charset DEFAULT_CHARSET = CharsetUtil.UTF_8;


    public static final int SGIP_HEADER_LENGTH = 20;

    public static final int BIND = 0x1;

    public static final int BIND_RESP = 0x80000001;

    public static final int UNBIND = 0x2;

    public static final int UNBIND_RESP = 0x80000002;

    public static final int SUBMIT = 0x3;

    public static final int SUBMIT_RESP = 0x80000003;

    public static final int DELIVER = 0x4;

    public static final int DELIVER_RESP = 0x80000004;

    public static final int REPORT = 0x5;

    public static final int REPORT_RESP = 0x80000005;


    public static final int SGIP_CHECKUSER = 0x10;

    public static final int SGIP_CHECKUSER_RESP = 0x80000010;


    public static final int SGIP_USERRPT = 0x11;

    public static final int SGIP_USERRPT_RESP = 0x80000011;


    public static final int SGIP_TRACE = 0x1000;

    public static final int SGIP_TRACE_RESP = 0x80001000;


    // header
    public static final int HEADER_MESSAGE_TOTAL_LENGTH = 4;
    public static final int HEADER_COMMAND_ID_LENGTH = 4;
    public static final int HEADER_SEQUENCE_NUMBER_LENGTH = 12;
    public static final int HEADER_TOTAL_LENGTH = HEADER_MESSAGE_TOTAL_LENGTH + HEADER_COMMAND_ID_LENGTH + HEADER_SEQUENCE_NUMBER_LENGTH;


    // bind
    public static final int BIND_TYPE_LENGTH = 4;         // LoginType 占用 4 字节
    public static final int BIND_NAME_LENGTH = 16;       // LoginName 占用 16 字节
    public static final int BIND_PASSWORD_LENGTH = 16;   // LoginPassword 占用 16 字节
    // reserve
    public static final int BIND_RESERVE_LENGTH = 8;           // Reserve 占用 8 字节

    // bind body total length
    public static final int BIND_TOTAL_MESSAGE_LENGTH =
            BIND_TYPE_LENGTH + BIND_NAME_LENGTH + BIND_PASSWORD_LENGTH + BIND_RESERVE_LENGTH;


    // response result
    public static final int RESPONSE_RESULT_TYPE_LENGTH = 1;         // LoginType 占用 4 字节


    // submit
    public static final int SUBMIT_SP_NUMBER_LEN = 21;
    public static final int SUBMIT_CHARGE_NUMBER_LEN = 21;
    public static final int SUBMIT_USER_NUMBER_LEN = 100;
    public static final int SUBMIT_CORP_ID_LEN = 5;
    public static final int SUBMIT_SERVICE_TYPE_LEN = 10;
    public static final int SUBMIT_FEE_VALUE_LEN = 6;
    public static final int SUBMIT_GIVEN_VALUE_LEN = 6;
    public static final int SUBMIT_EXPIRE_TIME_LEN = 16;
    public static final int SUBMIT_SCHEDULE_TIME_LEN = 16;
    public static final int SUBMIT_RESERVE_LEN = 8;

    public static final int SGIP_SUBMIT_TOTAL_LENGTH =
            SUBMIT_SP_NUMBER_LEN +
                    SUBMIT_CHARGE_NUMBER_LEN +
                    SUBMIT_USER_NUMBER_LEN +
                    SUBMIT_CORP_ID_LEN +
                    SUBMIT_SERVICE_TYPE_LEN +
                    SUBMIT_FEE_VALUE_LEN + SUBMIT_GIVEN_VALUE_LEN + SUBMIT_EXPIRE_TIME_LEN +
                    SUBMIT_SCHEDULE_TIME_LEN + SUBMIT_RESERVE_LEN;

}
