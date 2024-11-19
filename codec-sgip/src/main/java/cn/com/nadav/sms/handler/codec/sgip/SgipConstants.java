package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class SgipConstants {


    /**
     * Default character set (UTF-8)
     */
    public static final Charset DEFAULT_CHARSET = CharsetUtil.UTF_8;


    public static final int SGIP_HEADER_LENGTH = 20;

    public static final int SGIP_BIND = 0x1;

    public static final int SGIP_BIND_RESP = 0x80000001;

    public static final int SGIP_UNBIND = 0x2;

    public static final int SGIP_UNBIND_RESP = 0x80000002;

    public static final int SGIP_SUBMIT = 0x3;

    public static final int SGIP_SUBMIT_RESP = 0x80000003;

    public static final int SGIP_DELIVER = 0x4;

    public static final int SGIP_DELIVER_RESP = 0x80000004;

    public static final int SGIP_REPORT = 0x5;

    public static final int SGIP_REPORT_RESP = 0x80000005;


    public static final int SGIP_CHECKUSER = 0x10;

    public static final int SGIP_CHECKUSER_RESP = 0x80000010;


    public static final int SGIP_USERRPT = 0x11;

    public static final int SGIP_USERRPT_RESP = 0x80000011;


    public static final int SGIP_TRACE = 0x1000;

    public static final int SGIP_TRACE_RESP = 0x80001000;


    public static final int BIND_TYPE_LENGTH = 4;         // LoginType 占用 4 字节
    public static final int LOGIN_NAME_LENGTH = 16;       // LoginName 占用 16 字节
    public static final int LOGIN_PASSWORD_LENGTH = 16;   // LoginPassword 占用 16 字节
    public static final int RESERVE_LENGTH = 8;           // Reserve 占用 8 字节
    public static final int BIND_TOTAL_MESSAGE_LENGTH =
            BIND_TYPE_LENGTH + LOGIN_NAME_LENGTH + LOGIN_PASSWORD_LENGTH + RESERVE_LENGTH;


    public static final int RESPONSE_RESULT_TYPE_LENGTH = 1;         // LoginType 占用 4 字节

}
