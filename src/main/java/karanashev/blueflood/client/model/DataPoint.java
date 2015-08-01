package karanashev.blueflood.client.model;

import karanashev.blueflood.client.datetime.TimeInterval;
import org.joda.time.DateTime;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public final class DataPoint {

    private final DateTime collectionTime;
    private final TimeInterval timeToLive;
    private final BigDecimal metricValue;
    private final String metricName;

    public DataPoint(@Nonnull DateTime collectionTime, @Nonnull TimeInterval timeToLive, @Nonnull BigDecimal metricValue, @Nonnull String metricName) {
        this.collectionTime = collectionTime;
        this.timeToLive = timeToLive;
        this.metricValue = metricValue;
        this.metricName = metricName;
    }

    @Nonnull
    public DateTime collectionTime() {
        return collectionTime;
    }

    @Nonnull
    public TimeInterval timeToLive() {
        return timeToLive;
    }

    @Nonnull
    public BigDecimal metricValue() {
        return metricValue;
    }

    @Nonnull
    public String metricName() {
        return metricName;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
                "collectionTime=" + collectionTime +
                ", timeToLive=" + timeToLive +
                ", metricValue=" + metricValue +
                ", metricName='" + metricName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataPoint dataPoint = (DataPoint) o;

        if (!collectionTime.equals(dataPoint.collectionTime)) return false;
        if (!timeToLive.equals(dataPoint.timeToLive)) return false;
        if (!metricValue.equals(dataPoint.metricValue)) return false;
        return metricName.equals(dataPoint.metricName);

    }

    @Override
    public int hashCode() {
        int result = collectionTime.hashCode();
        result = 31 * result + timeToLive.hashCode();
        result = 31 * result + metricValue.hashCode();
        result = 31 * result + metricName.hashCode();
        return result;
    }
}
