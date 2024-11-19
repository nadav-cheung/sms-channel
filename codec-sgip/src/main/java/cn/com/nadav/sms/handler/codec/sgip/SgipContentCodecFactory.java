package cn.com.nadav.sms.handler.codec.sgip;

import java.util.HashMap;
import java.util.Map;

public class SgipContentCodecFactory {

    private SgipContentCodecFactory() {

    }

    public static final SgipContentCodecFactory INSTANCE = new SgipContentCodecFactory();


    private static final SgipBindContentCodec SGIP_BIND_CONTENT_CODEC = new SgipBindContentCodec();


    private static final Map<SgipOpCode, SgipContentCodec<? extends SgipContent>> codecMap = new HashMap<>();

    static {
        codecMap.put(SgipOpCode.BIND, SGIP_BIND_CONTENT_CODEC);
    }


    public SgipContentCodec<? extends SgipContent> getCodec(SgipOpCode sgipOpCode) {
        return codecMap.get(sgipOpCode);
    }

}
