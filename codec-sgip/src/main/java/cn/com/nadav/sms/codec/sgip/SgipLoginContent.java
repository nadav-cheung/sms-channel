package cn.com.nadav.sms.codec.sgip;

import io.netty.buffer.ByteBuf;

public class SgipLoginContent extends AbstractSgipContent {

    private int loginType;
    private String loginName;
    private String password;

    private String reserve;

    public SgipLoginContent(ByteBuf content) {
        super(content);
        decode(content);
    }

    private void decode(ByteBuf content) {
        this.loginType = content.readByte();
        byte[] nameBytes = new byte[16];
        content.readBytes(nameBytes);
        this.loginName = new String(nameBytes).trim();

        byte[] passwordBytes = new byte[16];
        content.readBytes(passwordBytes);
        this.password = new String(passwordBytes).trim();

        byte[] reserveBytes = new byte[8];
        content.readBytes(reserveBytes);
        this.reserve = new String(reserveBytes).trim();

    }

    protected SgipContent createNewInstance(ByteBuf content) {
        return new SgipLoginContent(content);
    }

    public int getLoginType() {
        return loginType;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }


}
