package cn.com.nadav.sms.handler.codec.sgip;

import cn.com.nadav.sms.handler.codec.sgip.pdu.SgipSequenceNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultSgipSequenceNumberTest {

    private static final int INITIAL_NODE_ID = 12345;
    private static final int INITIAL_TIMESTAMP = 67890;
    private static final int INITIAL_SEQUENCE_ID = 123;

    private DefaultSgipSequenceNumber original;
    private SgipSequenceNumber copy;

    @BeforeEach
    public void setUp() {
        original = createSequenceNumber(INITIAL_NODE_ID, INITIAL_TIMESTAMP, INITIAL_SEQUENCE_ID);
        copy = original.copy();
    }

    @Test
    public void testCopyCreatesIdenticalObject() {
        assertSequenceNumbersEqual(original, copy);
    }

    @Test
    public void testCopyWithDifferentValues() {
        copy = createSequenceNumber(54321, 98765, 321).copy();
        assertSequenceNumbersEqual(createSequenceNumber(54321, 98765, 321), copy);
    }

    private DefaultSgipSequenceNumber createSequenceNumber(int nodeId, int currentTimestamp, int sequenceId) {
        return new DefaultSgipSequenceNumber(nodeId, currentTimestamp, sequenceId);
    }

    private void assertSequenceNumbersEqual(SgipSequenceNumber expected, SgipSequenceNumber actual) {
        assertNotNull(actual);
        assertNotSame(expected, actual);
        assertEquals(expected.getNodeId(), actual.getNodeId());
        assertEquals(expected.getCurrentTimestamp(), actual.getCurrentTimestamp());
        assertEquals(expected.getSequenceId(), actual.getSequenceId());
    }
}