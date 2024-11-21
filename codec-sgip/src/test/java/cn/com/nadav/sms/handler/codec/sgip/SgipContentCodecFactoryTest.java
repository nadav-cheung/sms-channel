package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipContent;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SgipContentCodecFactoryTest {

    private SgipContentCodecFactory factory;

    @BeforeEach
    void setUp() {
        factory = SgipContentCodecFactory.getInstance();
    }

    private void assertCodecIsInstanceOf(SgipOpCode opCode, Class<? extends SgipContentCodec<?>> expectedClass) {
        SgipContentCodec<?> codec = factory.getCodec(opCode);
        assertNotNull(codec);
        assertTrue(expectedClass.isInstance(codec));
    }

    @Test
    void testGetCodecForBind() {
        assertCodecIsInstanceOf(SgipOpCode.BIND, SgipBindContentCodec.class);
    }

    @Test
    void testGetCodecForUnbindResp() {
        assertCodecIsInstanceOf(SgipOpCode.UNBIND_RESP, SgipEmptyContentCodec.class);
    }

    @Test
    void testGetCodecForSubmit() {
        assertCodecIsInstanceOf(SgipOpCode.SUBMIT, SgipSubmitContentCodec.class);
    }

    @Test
    void testGetCodecForBindResp() {
        assertCodecIsInstanceOf(SgipOpCode.BIND_RESP, SgipResponseContentCodec.class);
    }

    @Test
    void testGetCodecForNonExistentOpCode() {
        SgipOpCode nonExistentOpCode = new SgipOpCode(999, 1000, "NON_EXISTENT");
        assertThrows(DecoderException.class, () -> factory.getCodec(nonExistentOpCode));
    }

    @Test
    void testRegisterAndRetrieveCodec() {
        // Use extracted class instead of anonymous inner class
        SgipContentCodec<SgipContent> customCodec = new CustomSgipContentCodec();

        // Introduce constants for opCode values
        final int customMainCode = 888;
        final int customPairCode = 889;
        final String customName = "CUSTOM";

        SgipOpCode customOpCode = new SgipOpCode(customMainCode, customPairCode, customName);
        SgipContentCodecFactory.registerCodec(customOpCode, customCodec);

        SgipContentCodecFactory factory = SgipContentCodecFactory.getInstance();
        SgipContentCodec<?> retrievedCodec = factory.getCodec(customOpCode);

        assertNotNull(retrievedCodec);
        assertSame(customCodec, retrievedCodec);
    }

    class CustomSgipContentCodec implements SgipContentCodec<SgipContent> {
        @Override
        public SgipContent decodeSgipContent(ByteBuf in) {
            return new SgipContent() {
                @Override
                public Class<? extends SgipContent> getContentType() {
                    return getClass();
                }

                @Override
                public DecoderResult decoderResult() {
                    return DecoderResult.SUCCESS;
                }

                @Override
                public void setDecoderResult(DecoderResult result) {
                    // implementation here
                }
            };
        }

        @Override
        public void encodeSgipContent(SgipContent msg, ByteBuf out) {
            // encoding logic here
        }
    }
}