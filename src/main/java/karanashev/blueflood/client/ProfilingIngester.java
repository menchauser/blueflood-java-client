package karanashev.blueflood.client;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class ProfilingIngester implements Ingester {
    private final Ingester ingester;

    public ProfilingIngester(Ingester ingester) {
        this.ingester = ingester;
    }

    @Override
    public IngestionStatus ingest(DataPoints dataPoints) {
        long start = System.nanoTime();
        IngestionStatus result = ingest(dataPoints);
        long elapsed = System.nanoTime() - start;
        System.out.println("Ingestion took " + (elapsed / 1000) + " microseconds");
        return result;
    }
}
