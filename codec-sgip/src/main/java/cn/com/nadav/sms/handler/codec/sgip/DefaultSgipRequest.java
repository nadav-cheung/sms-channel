package cn.com.nadav.sms.handler.codec.sgip;

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
    public SgipRequest setCommandId(int commandId) {
        getHeader().setCommandId(commandId);
        return this;
    }

    @Override
    public SgipRequest setSgipMethod(SgipOpCode sgipOpCode) {
        this.sgipOpCode = sgipOpCode;
        return this;
    }

}
