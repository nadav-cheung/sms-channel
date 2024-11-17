package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;

public class SgipSubmitContentResponse extends AbstractSgipContent {

    private short result = 0;
    private String reserve;


    public SgipSubmitContentResponse(ByteBuf content) {
        super(content);
    }


}
