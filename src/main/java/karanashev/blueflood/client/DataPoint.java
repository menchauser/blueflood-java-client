package karanashev.blueflood.client;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class DataPoint {

    private final Date collectionTime;
    private final long ttlInSeconds;
    private final BigDecimal metricValue;
    private final String metricName;

    public DataPoint(Date collectionTime, long ttlInSeconds, BigDecimal metricValue, String metricName) {
        this.collectionTime = collectionTime;
        this.ttlInSeconds = ttlInSeconds;
        this.metricValue = metricValue;
        this.metricName = metricName;
    }

    public Date collectionTime() {
        return collectionTime;
    }

    public long ttlInSeconds() {
        return ttlInSeconds;
    }

    public BigDecimal metricValue() {
        return metricValue;
    }

    public String metricName() {
        return metricName;
    }
}
