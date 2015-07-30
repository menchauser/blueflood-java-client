package karanashev.blueflood.client;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public final class DataPoint {

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

    @Override
    public String toString() {
        return "DataPoint{" +
                "collectionTime=" + collectionTime +
                ", ttlInSeconds=" + ttlInSeconds +
                ", metricValue=" + metricValue +
                ", metricName='" + metricName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataPoint dataPoint = (DataPoint) o;

        if (ttlInSeconds != dataPoint.ttlInSeconds) return false;
        if (!collectionTime.equals(dataPoint.collectionTime)) return false;
        if (!metricValue.equals(dataPoint.metricValue)) return false;
        return metricName.equals(dataPoint.metricName);

    }

    @Override
    public int hashCode() {
        int result = collectionTime.hashCode();
        result = 31 * result + (int) (ttlInSeconds ^ (ttlInSeconds >>> 32));
        result = 31 * result + metricValue.hashCode();
        result = 31 * result + metricName.hashCode();
        return result;
    }
}
