package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.DefaultSgipHeader;
import cn.com.nadav.sms.handler.codec.sgip.pdu.DefaultSgipRequest;
import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipRequest;
import cn.com.nadav.sms.handler.codec.sgip.utils.SgipRequestUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SgipRequestDecoderTest {

    private static final int HEADER_LENGTH = 4;

    private SgipRequestDecoder createDecoder() {
        return new SgipRequestDecoder();
    }

    private ByteBuf prepareBuffer(int length, int actualLength) {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeInt(length);
        buffer.writeBytes(new byte[actualLength - HEADER_LENGTH]);
        buffer.writerIndex(actualLength);
        return buffer;
    }

    private Object setupDecoderAndContext(ByteBuf in) throws Exception {
        SgipRequestDecoder decoder = createDecoder();
        ChannelHandlerContext ctx = Mockito.mock(ChannelHandlerContext.class);
        return decoder.decode(ctx, in);
    }

    @Test
    public void returnsNullWhenFrameIsNull() throws Exception {
        ByteBuf in = Unpooled.buffer();
        Object result = setupDecoderAndContext(in);
        assertNull(result);
    }

    @Test
    public void decodesValidFrame() throws Exception {
        ByteBuf in = prepareBuffer(12, 12);
        SgipRequestUtil sgipRequestUtil = spy(SgipRequestUtil.class);
        doReturn(new DefaultSgipRequest(new DefaultSgipHeader())).when(sgipRequestUtil).decodeSgipRequest(any(), any(), any());
        Object result = setupDecoderAndContext(in);
        assertNotNull(result);
        assertTrue(result instanceof SgipRequest);
    }

    @Test
    public void decodeFailsWhenBufferIsShorterThanDeclaredLength() throws Exception {
        ByteBuf in = prepareBuffer(10, 9); // fewer bytes than declared length
        Object result = setupDecoderAndContext(in);
        assertNull(result);
    }
}