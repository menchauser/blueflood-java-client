package karanashev.blueflood.client;

import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

/**
 * Author: Karanashev
 * Date: 30.07.15
 */
public class ProfilingIngesterTest {

    @Test
    public void profilingIngestionInvokesInnerIngestion() throws Exception {
        Ingester innerIngester = mock(Ingester.class);
        ProfilingIngester profilingIngester = new ProfilingIngester(innerIngester);
        DataPoints dataPoints = new DataPoints().add(new DateTime(), 1000, BigDecimal.ONE, "example.one");

        profilingIngester.ingest(dataPoints);

        verify(innerIngester, only()).ingest(dataPoints);
    }
}