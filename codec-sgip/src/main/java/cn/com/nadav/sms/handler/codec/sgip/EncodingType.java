package cn.com.nadav.sms.handler.codec.sgip;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public enum EncodingType {
    ASCII(0, "纯ASCII字符串", StandardCharsets.US_ASCII),
    WRITE_CARD(3, "写卡操作", StandardCharsets.UTF_8), // 假定写卡操作使用UTF-8
    BINARY(4, "二进制编码", StandardCharsets.ISO_8859_1), // 假定二进制编码使用ISO-8859-1
    UCS2(8, "UCS2编码", StandardCharsets.UTF_16BE), // UCS2 (UTF-16 Big Endian)
    GBK(15, "GBK编码", Charset.forName("GBK"));

    private final int key;
    private final String description;
    private final Charset charset;

    EncodingType(int key, String description, Charset charset) {
        this.key = key;
        this.description = description;
        this.charset = charset;
    }

    public static EncodingType fromKey(int key) {
        for (EncodingType type : EncodingType.values()) {
            if (type.key == key) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown encoding type key: " + key);
    }

    public int getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public Charset getCharset() {
        return charset;
    }

    @Override
    public String toString() {
        return key + ": " + description;
    }
}
