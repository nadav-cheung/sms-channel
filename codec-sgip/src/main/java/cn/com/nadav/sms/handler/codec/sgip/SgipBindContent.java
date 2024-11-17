package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;

public class SgipBindContent extends AbstractSgipContent {

    private int loginType;
    private String loginName;
    private String password;
    private String reserve;

    public SgipBindContent(ByteBuf content) {
        super(content);
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

}
