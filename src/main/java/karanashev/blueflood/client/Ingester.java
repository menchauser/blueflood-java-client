package karanashev.blueflood.client;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public interface Ingester {
    IngestionStatus ingest(DataPoints dataPoints);

    enum IngestionStatus {
        OK, ERROR
    }
}
