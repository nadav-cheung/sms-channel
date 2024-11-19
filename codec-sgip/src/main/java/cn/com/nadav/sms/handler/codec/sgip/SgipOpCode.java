package cn.com.nadav.sms.handler.codec.sgip;

import static io.netty.util.internal.ObjectUtil.checkNotNull;

public class SgipOpCode implements Comparable<SgipOpCode> {

    public static final SgipOpCode BIND = new SgipOpCode(SgipConstants.BIND, "BIND");

    public static final SgipOpCode BIND_RESP = new SgipOpCode(SgipConstants.BIND_RESP, "BIND_RESP");

    public static final SgipOpCode UNBIND = new SgipOpCode(SgipConstants.UNBIND, "UNBIND");

    public static final SgipOpCode UNBIND_RESP = new SgipOpCode(SgipConstants.UNBIND_RESP, "UNBIND_RESP");

    public static final SgipOpCode SUBMIT = new SgipOpCode(SgipConstants.SUBMIT, "SUBMIT");

    public static final SgipOpCode SUBMIT_RESP = new SgipOpCode(SgipConstants.SUBMIT_RESP, "SUBMIT_RESP");

    public static final SgipOpCode DELIVER = new SgipOpCode(SgipConstants.DELIVER, "DELIVER");

    public static final SgipOpCode DELIVER_RESP = new SgipOpCode(SgipConstants.DELIVER_RESP, "DELIVER_RESP");

    public static final SgipOpCode REPORT = new SgipOpCode(SgipConstants.REPORT, "REPORT");

    public static final SgipOpCode REPORT_RESP = new SgipOpCode(SgipConstants.REPORT_RESP, "REPORT_RESP");


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
            case SgipConstants.BIND:
                return BIND;
            case SgipConstants.BIND_RESP:
                return BIND_RESP;
            case SgipConstants.UNBIND:
                return UNBIND;
            case SgipConstants.UNBIND_RESP:
                return UNBIND_RESP;
            case SgipConstants.SUBMIT:
                return SUBMIT;
            case SgipConstants.SUBMIT_RESP:
                return SUBMIT_RESP;
            case SgipConstants.DELIVER:
                return DELIVER;
            case SgipConstants.DELIVER_RESP:
                return DELIVER_RESP;
            case SgipConstants.REPORT:
                return REPORT;
            case SgipConstants.REPORT_RESP:
                return REPORT_RESP;
            default:
                break;
        }

        return null;
    }


    @Override
    public int compareTo(SgipOpCode o) {
        return 0;
    }
}
