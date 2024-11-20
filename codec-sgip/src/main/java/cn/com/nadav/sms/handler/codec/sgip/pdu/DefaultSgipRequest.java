package cn.com.nadav.sms.handler.codec.sgip.pdu;

public class DefaultSgipRequest extends DefaultSgipMessage implements SgipRequest {

    private Object attachment;

    public DefaultSgipRequest(SgipHeader header) {
        super(header);
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
        SgipResponse response = new DefaultSgipResponse(header);
        // 序号相同
        response.header().setSequenceNumber(header.getSequenceNumber().copy());
        response.header().setCommandId(getSgipOpCode().getPair());
        return response;
    }

}
