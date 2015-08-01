package karanashev.blueflood.client.endpoints;

import karanashev.blueflood.client.model.DataPoints;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class LoggingIngestionEndpoint implements IngestionEndpoint {
    private final IngestionEndpoint ingestionEndpoint;

    public LoggingIngestionEndpoint(IngestionEndpoint ingestionEndpoint) {
        this.ingestionEndpoint = ingestionEndpoint;
    }

    @Override
    public IngestionResult ingest(DataPoints dataPoints) {
        System.out.println("Ingesting data points: " + dataPoints);
        IngestionResult result = ingestionEndpoint.ingest(dataPoints);
        System.out.println("Result: " + result);
        return result;
    }
}
