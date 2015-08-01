package karanashev.blueflood.client;

import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

/**
 * Author: Karanashev
 * Date: 30.07.15
 */
public class ProfilingIngestionEndpointTest {

    @Test
    public void profilingIngestionInvokesInnerIngestion() throws Exception {
        IngestionEndpoint innerIngestionEndpoint = mock(IngestionEndpoint.class);
        ProfilingIngestionEndpoint profilingIngester = new ProfilingIngestionEndpoint(innerIngestionEndpoint);
        DataPoints dataPoints = new DataPoints().add(new DateTime(), 1000, BigDecimal.ONE, "example.one");

        profilingIngester.ingest(dataPoints);

        verify(innerIngestionEndpoint, only()).ingest(dataPoints);
    }
}