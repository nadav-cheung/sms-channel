package cn.com.nadav.sms.handler.codec.sgip;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.DecoderResult;

public class DefaultSgipRequest extends DefaultSgipMessage implements SgipRequest {

    private SgipMethod sgipMethod;


    @Override
    public SgipMethod getSgipMethod() {
        return null;
    }

    @Override
    public SgipContent sgipContent() {
        return null;
    }

    @Override
    public Object attachment() {
        return null;
    }

    @Override
    public void setAttachment(Object attachment) {

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
    public SgipMessage setSgipMethod(SgipMethod sgipMethod) {
        return null;
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
    public ByteBuf content() {
        return null;
    }

    @Override
    public ByteBufHolder copy() {
        return null;
    }

    @Override
    public ByteBufHolder duplicate() {
        return null;
    }

    @Override
    public ByteBufHolder retainedDuplicate() {
        return null;
    }

    @Override
    public ByteBufHolder replace(ByteBuf content) {
        return null;
    }

    @Override
    public int refCnt() {
        return 0;
    }

    @Override
    public ByteBufHolder retain() {
        return null;
    }

    @Override
    public ByteBufHolder retain(int increment) {
        return null;
    }

    @Override
    public ByteBufHolder touch() {
        return null;
    }

    @Override
    public ByteBufHolder touch(Object hint) {
        return null;
    }

    @Override
    public boolean release() {
        return false;
    }

    @Override
    public boolean release(int decrement) {
        return false;
    }

    @Override
    public DecoderResult decoderResult() {
        return null;
    }

    @Override
    public void setDecoderResult(DecoderResult result) {

    }
}
