package karanashev.blueflood.client;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class DataPoints implements Iterable<DataPoint> {

    private final List<DataPoint> dataPointsList = new ArrayList<>();

    public DataPoints add(DateTime collectionTime, long ttlInSeconds, BigDecimal metricValue, String metricName) {
        dataPointsList.add(new DataPoint(collectionTime, ttlInSeconds, metricValue, metricName));
        return this;
    }

    @Override
    public Iterator<DataPoint> iterator() {
        return Collections.unmodifiableList(dataPointsList).iterator();
    }

    @Override
    public String toString() {
        return "DataPoints{" +
                "dataPointsList=" + dataPointsList +
                '}';
    }
}
