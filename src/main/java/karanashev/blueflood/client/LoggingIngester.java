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
    public IngestionStatus ingest(DataPoints dataPoints) {
        System.out.println("Ingesting data points: " + dataPoints);
        IngestionStatus result = ingester.ingest(dataPoints);
        System.out.println("Result: " + result);
        return result;
    }
}
