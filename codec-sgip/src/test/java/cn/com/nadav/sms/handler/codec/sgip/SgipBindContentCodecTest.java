package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipBindContent;
import cn.com.nadav.sms.handler.codec.sgip.utils.FixedLengthTextCodecUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SgipBindContentCodecTest {

    private static final int LOGIN_TYPE = 1;
    private static final String LOGIN_NAME = "testUser";
    private static final String PASSWORD = "testPass";
    private static final String RESERVE = "reserve";
    private static final int INVALID_LOGIN_TYPE = -1;

    @Test
    public void decodeSgipContent_normalFlow() throws Exception {
        ByteBuf byteBuf = createByteBufWithContent(LOGIN_TYPE, LOGIN_NAME, PASSWORD, RESERVE);
        SgipBindContent result = decodeContent(byteBuf);
        assertValidResult(result, LOGIN_TYPE, LOGIN_NAME, PASSWORD, RESERVE);
    }

    @Test
    public void decodeSgipContent_insufficientBytes() throws Exception {
        ByteBuf byteBuf = Unpooled.buffer(SgipConstants.BIND_TOTAL_MESSAGE_LENGTH - 1);
        byteBuf.writeInt(LOGIN_TYPE);
        FixedLengthTextCodecUtil.writeFixedLengthString(byteBuf, "testUser", SgipConstants.BIND_NAME_LENGTH - 1);
        FixedLengthTextCodecUtil.writeFixedLengthString(byteBuf, "testPass", SgipConstants.BIND_PASSWORD_LENGTH - 1);
        FixedLengthTextCodecUtil.writeFixedLengthString(byteBuf, "res", SgipConstants.BIND_RESERVE_LENGTH - 1);
        SgipBindContent result = decodeContent(byteBuf);
        assertNull(result);
    }

    @Test
    public void decodeSgipContent_emptyBuffer() throws Exception {
        ByteBuf byteBuf = Unpooled.buffer(0);
        SgipBindContent result = decodeContent(byteBuf);
        assertNull(result);
    }

    @Test
    public void decodeSgipContent_invalidLoginType() throws Exception {
        ByteBuf byteBuf = createByteBufWithContent(INVALID_LOGIN_TYPE, LOGIN_NAME, PASSWORD, RESERVE);
        SgipBindContent result = decodeContent(byteBuf);
        assertValidResult(result, INVALID_LOGIN_TYPE, LOGIN_NAME, PASSWORD, RESERVE);
    }

    private ByteBuf createByteBufWithContent(int loginType, String loginName, String password, String reserve) {
        ByteBuf byteBuf = Unpooled.buffer(SgipConstants.BIND_TOTAL_MESSAGE_LENGTH);
        byteBuf.writeInt(loginType);
        FixedLengthTextCodecUtil.writeFixedLengthString(byteBuf, loginName, SgipConstants.BIND_NAME_LENGTH);
        FixedLengthTextCodecUtil.writeFixedLengthString(byteBuf, password, SgipConstants.BIND_PASSWORD_LENGTH);
        FixedLengthTextCodecUtil.writeFixedLengthString(byteBuf, reserve, SgipConstants.BIND_RESERVE_LENGTH);
        return byteBuf;
    }

    private SgipBindContent decodeContent(ByteBuf byteBuf) throws Exception {
        SgipBindContentCodec codec = new SgipBindContentCodec();
        return codec.decodeSgipContent(byteBuf);
    }

    private void assertValidResult(SgipBindContent result, int loginType, String loginName, String password, String reserve) {
        assertNotNull(result);
        assertEquals(loginType, result.getLoginType());
        assertEquals(loginName, result.getLoginName());
        assertEquals(password, result.getPassword());
        assertEquals(reserve, result.getReserve());
    }
}