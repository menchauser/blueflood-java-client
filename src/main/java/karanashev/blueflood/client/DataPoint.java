package karanashev.blueflood.client;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class DataPoint {

    private final DateTime collectionTime;
    private final long ttlInSeconds;
    private final BigDecimal metricValue;
    private final String metricName;

    public DataPoint(DateTime collectionTime, long ttlInSeconds, BigDecimal metricValue, String metricName) {
        this.collectionTime = collectionTime;
        this.ttlInSeconds = ttlInSeconds;
        this.metricValue = metricValue;
        this.metricName = metricName;
    }

    public DateTime collectionTime() {
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
