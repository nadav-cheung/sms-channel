package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipContent;

import java.util.HashMap;
import java.util.Map;

public class SgipContentCodecFactory {

    private static final Map<SgipOpCode, SgipContentCodec<? extends SgipContent>> codecMap = new HashMap<>();

    private static final SgipBindContentCodec SGIP_BIND_CONTENT_CODEC = new SgipBindContentCodec();

    private SgipContentCodecFactory() {

    }

    static {
        registerCodec(SgipOpCode.BIND, SGIP_BIND_CONTENT_CODEC);
    }


    // 提供类型安全的注册方法
    public static <T extends SgipContent> void registerCodec(SgipOpCode opCode, SgipContentCodec<T> codec) {
        codecMap.put(opCode, codec);
    }


    public static final SgipContentCodecFactory INSTANCE = new SgipContentCodecFactory();


    @SuppressWarnings("unchecked")
    public <T extends SgipContent> SgipContentCodec<T> getCodec(SgipOpCode sgipOpCode) {
        return (SgipContentCodec<T>) codecMap.get(sgipOpCode);
    }

}
