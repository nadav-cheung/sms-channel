package cn.com.nadav.sms.handler.codec.sgip.pdu;

import io.netty.util.CharsetUtil;

import static io.netty.util.internal.ObjectUtil.checkNonEmptyAfterTrim;
import static io.netty.util.internal.ObjectUtil.checkPositiveOrZero;

/**
 * Represents the version of the SGIP (Short Message Gateway Interface Protocol).
 * This class provides functionalities to define and compare different versions of SGIP.
 * It supports major and minor versioning and maintains protocol details.
 */
public class SgipVersion implements Comparable<SgipVersion> {


    static final String SGIP_1_2_STRING = "SGIP/1.2";

    static final String SGIP_1_3_STRING = "SGIP/1.3";

    /**
     * SGIP/1.3
     */
    public static final SgipVersion SGIP_1_3 = new SgipVersion("SGIP", 1, 3, true, true);


    private final String protocolName;

    private final int majorVersion;

    private final int minorVersion;

    private final String text;

    private final boolean keepAliveDefault;

    private final byte[] bytes;



    private SgipVersion(
            String protocolName,
            int majorVersion,
            int minorVersion,
            boolean keepAliveDefault,
            boolean bytes) {
        protocolName = checkNonEmptyAfterTrim(protocolName, "protocolName").toUpperCase();

        for (int i = 0; i < protocolName.length(); i ++) {
            if (Character.isISOControl(protocolName.charAt(i)) ||
                    Character.isWhitespace(protocolName.charAt(i))) {
                throw new IllegalArgumentException("invalid character in protocolName");
            }
        }

        checkPositiveOrZero(majorVersion, "majorVersion");
        checkPositiveOrZero(minorVersion, "minorVersion");

        this.protocolName = protocolName;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        text = protocolName + '/' + majorVersion + '.' + minorVersion;
        this.keepAliveDefault = keepAliveDefault;

        if (bytes) {
            this.bytes = text.getBytes(CharsetUtil.US_ASCII);
        } else {
            this.bytes = null;
        }
    }


    @Override
    public int compareTo(SgipVersion o) {
        return 0;
    }
}
