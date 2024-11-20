package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipContent;
import io.netty.handler.codec.DecoderException;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for creating and managing SGIP content codecs.
 * This factory maintains a registry of codecs for various SGIP operation codes,
 * providing a centralized way to retrieve the appropriate codec for encoding or decoding SGIP messages.
 */
public class SgipContentCodecFactory {

    private static final Map<SgipOpCode, SgipContentCodec<? extends SgipContent>> CODEC_MAP = new HashMap<>();

    private static final SgipBindContentCodec SGIP_BIND_CONTENT_CODEC = new SgipBindContentCodec();

    private static final SgipEmptyContentCodec SGIP_EMPTY_CONTENT_CODEC = new SgipEmptyContentCodec();

    private static final SgipResponseContentCodec SGIP_RESPONSE_CONTENT_CODEC = new SgipResponseContentCodec();

    static {
        registerCodec(SgipOpCode.BIND, SGIP_BIND_CONTENT_CODEC);

        registerCodec(SgipOpCode.UNBIND_RESP, SGIP_EMPTY_CONTENT_CODEC);


        // response
        registerCodec(SgipOpCode.BIND_RESP, SGIP_RESPONSE_CONTENT_CODEC);
        registerCodec(SgipOpCode.SUBMIT_RESP, SGIP_RESPONSE_CONTENT_CODEC);
        registerCodec(SgipOpCode.DELIVER_RESP, SGIP_RESPONSE_CONTENT_CODEC);
        registerCodec(SgipOpCode.REPORT_RESP, SGIP_RESPONSE_CONTENT_CODEC);

        registerCodec(SgipOpCode.UNBIND_RESP, SGIP_EMPTY_CONTENT_CODEC);
    }

    public static SgipContentCodecFactory getInstance() {
        return Holder.INSTANCE;
    }


    private SgipContentCodecFactory() {

    }

    // 提供类型安全的注册方法
    public static <T extends SgipContent> void registerCodec(SgipOpCode opCode, SgipContentCodec<T> codec) {
        CODEC_MAP.put(opCode, codec);
    }

    @SuppressWarnings("unchecked")
    public <T extends SgipContent> SgipContentCodec<T> getCodec(SgipOpCode sgipOpCode) {
        SgipContentCodec<? extends SgipContent> sgipContentCodec = CODEC_MAP.get(sgipOpCode);
        if (sgipContentCodec == null) {
            throw new DecoderException("无法找到消息编解码器");
        }
        return (SgipContentCodec<T>) sgipContentCodec;
    }

    // 使用静态内部类实现单例
    private static class Holder {
        private static final SgipContentCodecFactory INSTANCE = new SgipContentCodecFactory();
    }

}
