package cn.com.nadav.sms.handler.codec.sgip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DatacenterMachineSequenceNumberGeneratorTest {

    private static final int INITIAL_SEQ_ID = 100;
    private static final int NODE_ID = 0;
    private static final int DEFAULT_DATACENTER_ID = 0;
    private static final int DEFAULT_MACHINE_ID = 0;

    @Test
    public void testGenerateSequenceId_withValidDataCenterIdAndMachineId() {
        int dataCenterId = 1;
        int machineId = 2;
        DatacenterMachineSequenceNumberGenerator generator = createGenerator(dataCenterId, machineId, NODE_ID);
        int expectedSeqId = calculateExpectedSequenceId(INITIAL_SEQ_ID, dataCenterId, machineId);
        assertEquals(expectedSeqId, generator.generateSequenceId(INITIAL_SEQ_ID));
    }

    @Test
    public void testGenerateSequenceId_withMaxDataCenterIdAndMachineId() {
        final int MAX_DATA_CENTER_ID = 15;
        final int MAX_MACHINE_ID = 15;
        DatacenterMachineSequenceNumberGenerator generator = createGenerator(MAX_DATA_CENTER_ID, MAX_MACHINE_ID, NODE_ID);
        int expectedSeqId = calculateExpectedSequenceId(INITIAL_SEQ_ID, MAX_DATA_CENTER_ID, MAX_MACHINE_ID);
        assertEquals(expectedSeqId, generator.generateSequenceId(INITIAL_SEQ_ID));
    }

    @Test
    public void testGenerateSequenceId_withMinDataCenterIdAndMachineId() {
        DatacenterMachineSequenceNumberGenerator generator = createGenerator(DEFAULT_DATACENTER_ID, DEFAULT_MACHINE_ID, NODE_ID);
        int expectedSeqId = calculateExpectedSequenceId(INITIAL_SEQ_ID, DEFAULT_DATACENTER_ID, DEFAULT_MACHINE_ID);
        assertEquals(expectedSeqId, generator.generateSequenceId(INITIAL_SEQ_ID));
    }

    @Test
    public void testConstructor_withInvalidDataCenterIdLower() {
        int invalidDataCenterId = -1;
        int machineId = 0;
        assertInvalidDataCenterId(invalidDataCenterId, machineId);
    }

    @Test
    public void testConstructor_withInvalidDataCenterIdHigher() {
        int invalidDataCenterId = 16;
        int machineId = 0;
        assertInvalidDataCenterId(invalidDataCenterId, machineId);
    }

    @Test
    public void testConstructor_withInvalidMachineIdLower() {
        int invalidMachineId = -1;
        assertInvalidMachineId(invalidMachineId);
    }

    @Test
    public void testConstructor_withInvalidMachineIdHigher() {
        int invalidMachineId = 16;
        assertInvalidMachineId(invalidMachineId);
    }

    private DatacenterMachineSequenceNumberGenerator createGenerator(int dataCenterId, int machineId, int nodeId) {
        return new DatacenterMachineSequenceNumberGenerator(dataCenterId, machineId, nodeId);
    }

    private int calculateExpectedSequenceId(int currentSeqId, int dataCenterId, int machineId) {
        return currentSeqId + ((dataCenterId << 8) | machineId);
    }

    private void assertInvalidDataCenterId(int dataCenterId, int machineId) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new DatacenterMachineSequenceNumberGenerator(dataCenterId, machineId, NODE_ID)
        );
        assertEquals("Data Center ID must be between 0 and 15", exception.getMessage());
    }

    private void assertInvalidMachineId(int machineId) {
        int dataCenterId = 0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new DatacenterMachineSequenceNumberGenerator(dataCenterId, machineId, NODE_ID)
        );
        assertEquals("Machine ID must be between 0 and 15", exception.getMessage());
    }
}