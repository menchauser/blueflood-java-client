package karanashev.blueflood.client.endpoints;

/**
 * Author: Karanashev
 * Date: 06.08.15
 */
public class IngestionResult {
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

    public enum IngestionStatus {
        OK, ERROR
    }
}
