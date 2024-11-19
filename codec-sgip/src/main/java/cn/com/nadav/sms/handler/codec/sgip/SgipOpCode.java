package cn.com.nadav.sms.handler.codec.sgip;

import static io.netty.util.internal.ObjectUtil.checkNotNull;

public class SgipOpCode implements Comparable<SgipOpCode> {

    public static final SgipOpCode BIND = new SgipOpCode(SgipConstants.SGIP_BIND, "BIND");

    public static final SgipOpCode BIND_RESP = new SgipOpCode(SgipConstants.SGIP_BIND_RESP, "BIND_RESP");

    public static final SgipOpCode UNBIND = new SgipOpCode(SgipConstants.SGIP_UNBIND, "UNBIND");

    public static final SgipOpCode UNBIND_RESP = new SgipOpCode(SgipConstants.SGIP_UNBIND_RESP, "UNBIND_RESP");

    public static final SgipOpCode SUBMIT = new SgipOpCode(SgipConstants.SGIP_SUBMIT, "SUBMIT");

    public static final SgipOpCode SUBMIT_RESP = new SgipOpCode(SgipConstants.SGIP_SUBMIT_RESP, "SUBMIT_RESP");

    public static final SgipOpCode DELIVER = new SgipOpCode(SgipConstants.SGIP_DELIVER, "DELIVER");

    public static final SgipOpCode DELIVER_RESP = new SgipOpCode(SgipConstants.SGIP_DELIVER_RESP, "DELIVER_RESP");

    public static final SgipOpCode REPORT = new SgipOpCode(SgipConstants.SGIP_REPORT, "REPORT");

    public static final SgipOpCode REPORT_RESP = new SgipOpCode(SgipConstants.SGIP_REPORT_RESP, "REPORT_RESP");


    private final int code;

    private final String name;

    private String text;


    public SgipOpCode(int code) {
        this(code, "UNKNOWN");
    }

    public SgipOpCode(int code, String name) {
        this.code = code;
        this.name = checkNotNull(name, "name");
    }


    /**
     * Returns the {@link SgipOpCode} instance of the specified byte value.
     */
    public static SgipOpCode valueOf(int b) {
        switch (b) {
            case SgipConstants.SGIP_BIND:
                return BIND;
            case 0x01:
                return IQUERY;
            case 0x02:
                return STATUS;
            case 0x04:
                return NOTIFY;
            case 0x05:
                return UPDATE;
            default:
                break;
        }

        return new SgipOpCode(b);
    }


    @Override
    public int compareTo(SgipOpCode o) {
        return 0;
    }
}
