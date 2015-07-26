package karanashev.blueflood.client;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public final class Ingester {
    public IngestionStatus ingest(DataPoint dataPoint) {
        return IngestionStatus.OK;
    }

    public enum IngestionStatus {
        OK, ERROR
    }
}
