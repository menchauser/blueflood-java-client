package karanashev.blueflood.client;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class LoggingIngester implements Ingester {
    private final Ingester ingester;

    public LoggingIngester(Ingester ingester) {
        this.ingester = ingester;
    }

    @Override
    public IngestionResult ingest(DataPoints dataPoints) {
        System.out.println("Ingesting data points: " + dataPoints);
        IngestionResult result = ingester.ingest(dataPoints);
        System.out.println("Result: " + result);
        return result;
    }
}
