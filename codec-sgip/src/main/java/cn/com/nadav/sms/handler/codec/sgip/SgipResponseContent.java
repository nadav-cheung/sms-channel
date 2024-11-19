package cn.com.nadav.sms.handler.codec.sgip;

public class SgipResponseContent extends AbstractSgipContent {

    private int result = 0;

    private String reserve;


    public SgipResponseContent() {
    }

    public SgipResponseContent(int result, String reserve) {
        this.result = result;
        this.reserve = reserve;
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
