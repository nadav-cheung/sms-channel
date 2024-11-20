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
        SgipHeader headerCopyFromRequest = new DefaultSgipHeader();
        headerCopyFromRequest.setCommandId(getSgipOpCode().getPair());
        headerCopyFromRequest.setSequenceNumber(getSequenceNumber().copy());
        return new DefaultSgipResponse(headerCopyFromRequest);
    }

}
