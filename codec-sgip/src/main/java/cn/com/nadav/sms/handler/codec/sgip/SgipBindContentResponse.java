package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;

public class SgipBindContentResponse extends AbstractSgipContent {

    private int result;

    private String reserve;

    public SgipBindContentResponse(ByteBuf content) {
        super(content);
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}
