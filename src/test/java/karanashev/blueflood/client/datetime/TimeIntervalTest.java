package karanashev.blueflood.client.datetime;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mukhamed Karanashev on 01.08.2015.
 */
public class TimeIntervalTest {
    
    @Test
    public void basicTimeIsStoredInSeconds() {
        TimeInterval timeInterval = new TimeInterval(300, TimeUnit.SECONDS);
        assertEquals(300, timeInterval.seconds());
    }

    @Test
    public void timeIsConvertableFromOtherDimensions() {
        TimeInterval timeInterval = new TimeInterval(1, TimeUnit.DAYS);
        assertEquals(24 * 60 * 60, timeInterval.seconds());
    }

    @Test
    public void timeCouldBeSummarizedFromSeveralUnits() {
        TimeInterval timeInterval = new TimeInterval(1, TimeUnit.DAYS, 6, TimeUnit.HOURS);
        assertEquals(24 * 60 * 60 + 6 * 60 * 60, timeInterval.seconds());
    }

    @Test(expected = IllegalArgumentException.class)
    public void basicTimeCannotBeNegative() {
        new TimeInterval(-10, TimeUnit.MINUTES);
    }


    @Test(expected = IllegalArgumentException.class)
    public void summarizedTimeCannotBeNegative() {
        new TimeInterval(1, TimeUnit.MINUTES, -30, TimeUnit.SECONDS);
    }
}