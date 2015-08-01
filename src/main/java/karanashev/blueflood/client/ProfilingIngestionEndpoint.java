package karanashev.blueflood.client;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class ProfilingIngestionEndpoint implements IngestionEndpoint {
    private final IngestionEndpoint ingestionEndpoint;

    public ProfilingIngestionEndpoint(IngestionEndpoint ingestionEndpoint) {
        this.ingestionEndpoint = ingestionEndpoint;
    }

    @Override
    public IngestionResult ingest(DataPoints dataPoints) {
        long start = System.nanoTime();
        IngestionResult result = ingestionEndpoint.ingest(dataPoints);
        long elapsed = System.nanoTime() - start;
        System.out.println("Ingestion took " + (elapsed / 1000) + " microseconds");
        return result;
    }
}
