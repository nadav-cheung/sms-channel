package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipEmptyContent;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SgipEmptyContentCodecTest {

    private static final byte[] NON_EMPTY_BYTES = {1, 2, 3, 4};
    private SgipEmptyContentCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new SgipEmptyContentCodec();
    }

    @Test
    public void givenNonEmptyBuffer_whenDecodeSgipContent_thenBufferIsEmptyAndResultIsNotNull() throws Exception {
        ByteBuf buffer = createBufferWithBytes(NON_EMPTY_BYTES);
        SgipEmptyContent result = codec.decodeSgipContent(buffer);
        assertDecodeResult(result, buffer);
    }

    @Test
    public void givenEmptyBuffer_whenDecodeSgipContent_thenBufferIsEmptyAndResultIsNotNull() throws Exception {
        ByteBuf buffer = createBufferWithBytes(new byte[0]);
        SgipEmptyContent result = codec.decodeSgipContent(buffer);
        assertDecodeResult(result, buffer);
    }

    @Test
    public void givenNullBuffer_whenDecodeSgipContent_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> codec.decodeSgipContent(null), "Decoding with null buffer should throw NullPointerException");
    }

    private ByteBuf createBufferWithBytes(byte[] bytes) {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeBytes(bytes);
        return buffer;
    }

    private void assertDecodeResult(SgipEmptyContent result, ByteBuf buffer) {
        assertNotNull(result, "The result should not be null");
        assertEquals(0, buffer.readableBytes(), "The buffer should be empty after decoding");
    }
}