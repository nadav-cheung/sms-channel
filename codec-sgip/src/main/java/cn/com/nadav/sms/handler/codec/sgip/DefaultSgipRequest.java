package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.handler.codec.DecoderResult;

public class DefaultSgipRequest<T extends SgipContent> implements SgipRequest<T> {

    private SgipHeader header;

    private T sgipContent;


    public DefaultSgipRequest() {
    }

    @Override
    public T sgipContent() {
        return sgipContent;
    }

    @Override
    public SgipVersion protocolVersion() {
        return null;
    }

    @Override
    public SgipMessage setProtocolVersion(SgipVersion protocolVersion) {
        return null;
    }

    @Override
    public SgipHeader header() {
        return null;
    }

    @Override
    public SgipMessage setHeader(SgipHeader header) {
        return null;
    }

    @Override
    public int getCommandId() {
        return 0;
    }

    @Override
    public SgipMessage setCommandId(int commandId) {
        return null;
    }

    @Override
    public DecoderResult decoderResult() {
        return null;
    }

    @Override
    public void setDecoderResult(DecoderResult result) {

    }
}
