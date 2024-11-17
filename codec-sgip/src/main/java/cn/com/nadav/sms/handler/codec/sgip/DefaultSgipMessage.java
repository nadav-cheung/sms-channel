package cn.com.nadav.sms.handler.codec.sgip;

public abstract class DefaultSgipMessage implements SgipMessage {

    private SgipHeader header;

    private SgipVersion version;


    public DefaultSgipMessage() {
        this(SgipVersion.SGIP_1_3);
    }

    public DefaultSgipMessage(SgipVersion version) {
        this(version, SgipHeaderFactory.headerFactory());
    }

    public DefaultSgipMessage(SgipVersion version, SgipHeader header) {
        this.header = header;
        this.version = version;
    }


    /**
     * Creates a new instance.
     */
    protected DefaultSgipMessage(SgipVersion version, SgipHeaderFactory headerFactory) {
        this(version, headerFactory.newHeader());
    }


    @Override
    public SgipMessage setCommandId(int commandId) {
        this.header.setCommandId(commandId);
        return this;
    }

    @Override
    public int getCommandId() {
        return this.header.getCommandId();
    }

    @Override
    public SgipMessage setHeader(SgipHeader header) {
        this.header = header;
        return this;
    }

    @Override
    public SgipHeader header() {
        return this.header;
    }

    @Override
    public SgipMessage setProtocolVersion(SgipVersion protocolVersion) {
        this.version = protocolVersion;
        return this;
    }

    @Override
    public SgipVersion protocolVersion() {
        return this.version;
    }
}
