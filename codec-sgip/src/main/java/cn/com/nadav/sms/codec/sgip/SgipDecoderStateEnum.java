package cn.com.nadav.sms.codec.sgip;

public enum SgipDecoderStateEnum {

    START,            // 初始状态，等待协议头部

    HEADER_PARSED,    // 头部解析完成，准备解析消息体

    BODY_PARSING,     // 正在解析消息体

    DONE,             // 完成解析

    ERROR             // 错误状态，解析失败

}
