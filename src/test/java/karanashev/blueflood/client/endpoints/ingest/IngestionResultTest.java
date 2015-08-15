package karanashev.blueflood.client.endpoints.ingest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: Karanashev
 * Date: 06.08.15
 */
public class IngestionResultTest {

    @Test
    public void okResultIsSuccessful() {
        IngestionResult result = new IngestionResult(IngestionResult.IngestionStatus.OK);
        assertEquals(IngestionResult.IngestionStatus.OK, result.ingestionStatus());
        assertTrue(result.isSuccessful());
    }

    @Test
    public void errorResultIsNotSuccessful() {
        IngestionResult result = new IngestionResult(IngestionResult.IngestionStatus.ERROR);
        assertEquals(IngestionResult.IngestionStatus.ERROR, result.ingestionStatus());
        assertFalse(result.isSuccessful());
    }

    @Test
    public void defaultMessageIsEmpty() {
        IngestionResult result = new IngestionResult(IngestionResult.IngestionStatus.OK);
        assertEquals("", result.message());
    }
}