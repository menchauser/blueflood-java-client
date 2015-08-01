package karanashev.blueflood.client;

import karanashev.blueflood.client.datetime.DefaultTimeInterval;
import karanashev.blueflood.client.endpoints.IngestionEndpoint;
import karanashev.blueflood.client.endpoints.ProfilingIngestionEndpoint;
import karanashev.blueflood.client.model.DataPoints;
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
        DataPoints dataPoints = new DataPoints().add(new DateTime(), DefaultTimeInterval.HOUR.value(), BigDecimal.ONE, "example.one");

        profilingIngester.ingest(dataPoints);

        verify(innerIngestionEndpoint, only()).ingest(dataPoints);
    }
}