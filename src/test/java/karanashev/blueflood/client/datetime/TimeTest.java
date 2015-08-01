package karanashev.blueflood.client.datetime;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mukhamed Karanashev on 01.08.2015.
 */
public class TimeTest {
    
    @Test
    public void basicTimeIsStoredInSeconds() {
        Time time = new Time(300, TimeUnit.SECONDS);
        assertEquals(300, time.seconds());
    }

    @Test
    public void timeIsConvertableFromOtherDimensions() {
        Time time = new Time(1, TimeUnit.DAYS);
        assertEquals(24 * 60 * 60, time.seconds());
    }

    @Test
    public void timeCouldBeSummarizedFromSeveralUnits() {
        Time time = new Time(1, TimeUnit.DAYS, 6, TimeUnit.HOURS);
        assertEquals(24 * 60 * 60 + 6 * 60 * 60, time.seconds());
    }

    @Test(expected = IllegalArgumentException.class)
    public void basicTimeCannotBeNegative() {
        new Time(-10, TimeUnit.MINUTES);
    }


    @Test(expected = IllegalArgumentException.class)
    public void summarizedTimeCannotBeNegative() {
        new Time(1, TimeUnit.MINUTES, -30, TimeUnit.SECONDS);
    }
}