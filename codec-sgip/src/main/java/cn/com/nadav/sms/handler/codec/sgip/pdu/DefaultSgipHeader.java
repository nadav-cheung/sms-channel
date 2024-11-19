package cn.com.nadav.sms.handler.codec.sgip.pdu;

import cn.com.nadav.sms.handler.codec.sgip.SgipConstants;

public class DefaultSgipHeader implements SgipHeader {

    protected long messageLength;

    protected int commandId;


    /**
     * 消息header长度
     */
    private int headerLength;

    protected SgipSequenceNumber sgipSequenceNumber;


    public DefaultSgipHeader() {
        this.headerLength = SgipConstants.SGIP_HEADER_LENGTH;
    }

    @Override
    public long getMessageLength() {
        return this.messageLength;
    }

    @Override
    public void setMessageLength(long messageLength) {
        this.messageLength = messageLength;
    }

    @Override
    public int getCommandId() {
        return this.commandId;
    }

    @Override
    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    @Override
    public SgipSequenceNumber getSequenceNumber() {
        return this.sgipSequenceNumber;
    }

    @Override
    public void setSequenceNumber(SgipSequenceNumber sequenceNumber) {
        this.sgipSequenceNumber = sequenceNumber;
    }

    @Override
    public int getHeaderLength() {
        return this.headerLength;
    }


    @Override
    public void setHeaderLength(int headerLength) {
        this.headerLength = headerLength;
    }


    @Override
    public long getContentLength() {
        return this.messageLength - this.headerLength;
    }
}
