package cn.com.nadav.sms.handler.codec.sgip.utils;


import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

/**
 * Utility class for handling fixed-length text encoding and decoding.
 * This class provides methods to write fixed-length strings to a ByteBuf
 * and read fixed-length strings from a ByteBuf, with specific handling
 * for padding and trimming null characters.
 */
public class FixedLengthTextCodecUtil {

    private FixedLengthTextCodecUtil() {
    } // 防止实例化

    /**
     * 写定长字符串到 ByteBuf 中，左对齐并用 '\0' 填充空余部分。
     *
     * @param out    目标 ByteBuf
     * @param value  要写入的字符串
     * @param length 定长字节数
     */
    public static void writeFixedLengthString(ByteBuf out, String value, int length) {
        if (value == null) value = "";

        // 写入实际内容，截断多余部分
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        int writeLength = Math.min(bytes.length, length);
        out.writeBytes(bytes, 0, writeLength);

        // 用 '\0' 填充剩余部分
        if (writeLength < length) {
            out.writeZero(length - writeLength);
        }
    }

    /**
     * 从 ByteBuf 中读取定长字符串，去掉尾部的 '\0'。
     *
     * @param in     源 ByteBuf
     * @param length 定长字节数
     * @return 解析出的字符串
     */
    public static String readFixedLengthString(ByteBuf in, int length) {
        CharSequence charSequence = in.readCharSequence(length, StandardCharsets.UTF_8);

        // 去掉尾部 '\0'
        int end = charSequence.length();
        while (end > 0 && charSequence.charAt(end - 1) == '\0') {
            end--;
        }

        return charSequence.subSequence(0, end).toString();
    }

}
