package cn.com.nadav.sms.handler.codec.sgip.pdu;

import cn.com.nadav.sms.handler.codec.sgip.SgipOpCode;

public class DefaultSgipRequest extends DefaultSgipMessage implements SgipRequest {

    private SgipOpCode sgipOpCode;

    private Object attachment;

    public DefaultSgipRequest(SgipHeader header, SgipOpCode sgipOpCode) {
        super(header);
        this.sgipOpCode = sgipOpCode;
    }

    @Override
    public SgipOpCode getSgipOpCode() {
        return this.sgipOpCode;
    }

    @Override
    public Object attachment() {
        return this.attachment;
    }

    @Override
    public void setAttachment(Object attachment) {
        this.attachment = attachment;
    }

    @Override
    public int getCommandId() {
        return getHeader().getCommandId();
    }

    @Override
    public SgipSequenceNumber getSequenceNumber() {
        return null;
    }

    @Override
    public SgipResponse getResponse() {
        SgipHeader header = getHeader();
        SgipResponse response = new DefaultSgipResponse();
        // 序号相同
        response.header().setSequenceNumber(header.getSequenceNumber().copy());
        response.header().setCommandId(sgipOpCode.getPair());
        return response;
    }


    @Override
    public SgipRequest setSgipOpCode(SgipOpCode sgipOpCode) {
        this.sgipOpCode = sgipOpCode;
        return this;
    }


}
