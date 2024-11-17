package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;

public class SgipSubmitContent extends AbstractSgipContent {


    private String spnumber;
    private String chargenumber;
    private String[] usernumber = null;
    private String corpid;
    private String servicetype;
    private short feetype = 2;
    private String feevalue;
    private String givenvalue;
    private short agentflag = 0;
    private short morelatetomtflag = 0;
    private short priority = 9;
    private String expiretime;
    private String scheduletime;
    private short reportflag = 1;
    private short tppid = 0;
    private short tpudhi = 0;
    private SgipSmsDcs msgfmt;
    private short messagetype = 0;
    private int messagelength = 120;
    private String reserve;

    private byte[] msgContentBytes;
    private SmsMessage msg;


    public SgipSubmitContent(ByteBuf content) {
        super(content);
    }
}
