package cn.com.nadav.sms.handler.codec.sgip;

import static io.netty.util.internal.ObjectUtil.checkNotNull;

/**
 * Represents an operation code (OpCode) in the SGIP (Short Message Gateway Interface Protocol).
 * This class contains constants for various SGIP operation codes and their corresponding response codes.
 * It also provides utility methods to retrieve an instance of {@link SgipOpCode} based on a given code.
 */
public class SgipOpCode implements Comparable<SgipOpCode> {

    public static final SgipOpCode BIND = new SgipOpCode(SgipConstants.BIND, SgipConstants.BIND_RESP, "BIND");

    public static final SgipOpCode BIND_RESP = new SgipOpCode(SgipConstants.BIND_RESP, SgipConstants.BIND, "BIND_RESP");

    public static final SgipOpCode UNBIND = new SgipOpCode(SgipConstants.UNBIND, SgipConstants.UNBIND_RESP, "UNBIND");

    public static final SgipOpCode UNBIND_RESP = new SgipOpCode(SgipConstants.UNBIND_RESP, SgipConstants.UNBIND, "UNBIND_RESP");

    public static final SgipOpCode SUBMIT = new SgipOpCode(SgipConstants.SUBMIT, SgipConstants.SUBMIT_RESP, "SUBMIT");

    public static final SgipOpCode SUBMIT_RESP = new SgipOpCode(SgipConstants.SUBMIT_RESP, SgipConstants.SUBMIT, "SUBMIT_RESP");

    public static final SgipOpCode DELIVER = new SgipOpCode(SgipConstants.DELIVER, SgipConstants.DELIVER_RESP, "DELIVER");

    public static final SgipOpCode DELIVER_RESP = new SgipOpCode(SgipConstants.DELIVER_RESP, SgipConstants.DELIVER, "DELIVER_RESP");

    public static final SgipOpCode REPORT = new SgipOpCode(SgipConstants.REPORT, SgipConstants.REPORT_RESP, "REPORT");

    public static final SgipOpCode REPORT_RESP = new SgipOpCode(SgipConstants.REPORT_RESP, SgipConstants.REPORT, "REPORT_RESP");


    private final int code;

    private final int pair;

    private final String name;

    private String text;


    public SgipOpCode(int code, int pair, String name) {
        this.code = code;
        this.pair = pair;
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
        checkNotNull(o, "o");
        if (this == o) {
            return 0;
        }

        return code - o.code;
    }


    public int getCode() {
        return code;
    }

    public int getPair() {
        return pair;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
