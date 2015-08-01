package karanashev.blueflood.client;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public interface IngestionEndpoint {
    IngestionResult ingest(DataPoints dataPoints);

    class IngestionResult {
        private final IngestionStatus ingestionStatus;
        private final String message;

        public IngestionResult(IngestionStatus ingestionStatus) {
            this(ingestionStatus, "");
        }

        public IngestionResult(IngestionStatus ingestionStatus, String message) {
            this.ingestionStatus = ingestionStatus;
            this.message = message;
        }

        public IngestionStatus ingestionStatus() {
            return ingestionStatus;
        }

        public boolean isSuccessful() {
            return ingestionStatus() == IngestionStatus.OK;
        }

        public String message() {
            return message;
        }

        @Override
        public String toString() {
            return "IngestionResult{" +
                    "ingestionStatus=" + ingestionStatus +
                    '}';
        }
    }

    enum IngestionStatus {
        OK, ERROR
    }
}
