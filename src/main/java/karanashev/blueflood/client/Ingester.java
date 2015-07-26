package karanashev.blueflood.client;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public interface Ingester {
    IngestionResult ingest(DataPoints dataPoints);

    class IngestionResult {
        private final IngestionStatus ingestionStatus;

        public IngestionResult(IngestionStatus ingestionStatus) {
            this.ingestionStatus = ingestionStatus;
        }

        public IngestionStatus ingestionStatus() {
            return ingestionStatus;
        }
    }

    enum IngestionStatus {
        OK, ERROR
    }
}
