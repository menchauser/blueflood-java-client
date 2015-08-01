package karanashev.blueflood.client.model;

import karanashev.blueflood.client.datetime.DefaultTimeInterval;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Author: Karanashev
 * Date: 30.07.15
 */
public class DataPointsTest {

    @Test
    public void newDataPointsAreEmpty() {
        DataPoints dataPoints = new DataPoints();

        assertFalse("Newly created DataPoints should be empty but aren't", dataPoints.iterator().hasNext());
    }

    @Test
    public void singleDataPointShouldBeAddedToBatch() {
        DataPoints dataPoints = new DataPoints();
        DataPoint singlePoint = new DataPoint(new DateTime(), DefaultTimeInterval.HOUR.value(), BigDecimal.ONE, "example.metric");
        dataPoints.add(singlePoint.collectionTime(), DefaultTimeInterval.HOUR.value(), singlePoint.metricValue(), singlePoint.metricName());

        Iterator<DataPoint> iterator = dataPoints.iterator();
        assertTrue(iterator.hasNext());
        DataPoint resultPoint = iterator.next();
        assertEquals("DataPoint added to batch is not the DataPoint retrieved", singlePoint, resultPoint);
        assertFalse("Singleton DataPoints batch has more than one element", iterator.hasNext());
    }

    @Test
    public void dataPointsAreAddedInOrder() {
        DataPoints dataPoints = new DataPoints();
        DataPoint firstPoint = new DataPoint(DateTime.now(), DefaultTimeInterval.HOUR.value(), BigDecimal.ONE, "example.metric.one");
        DataPoint secondPoint = new DataPoint(DateTime.now(), DefaultTimeInterval.DAY.value(), BigDecimal.TEN, "example.metric.two");

        dataPoints
                .add(firstPoint.collectionTime(), DefaultTimeInterval.HOUR.value(), firstPoint.metricValue(), firstPoint.metricName())
                .add(secondPoint.collectionTime(), DefaultTimeInterval.DAY.value(), secondPoint.metricValue(), secondPoint.metricName());

        Iterator<DataPoint> iterator = dataPoints.iterator();
        DataPoint firstResult = iterator.next();
        DataPoint secondResult = iterator.next();

        assertEquals(firstResult, firstPoint);
        assertEquals(secondResult, secondPoint);
        assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void dataPointsBatchIsImmutable() {
        DataPoints dataPoints = new DataPoints();
        dataPoints.add(DateTime.now(), DefaultTimeInterval.HOUR.value(), BigDecimal.ONE, "test");

        Iterator<DataPoint> iterator = dataPoints.iterator();
        iterator.next();
        iterator.remove();
    }

}