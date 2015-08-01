package karanashev.blueflood.client.datetime;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mukhamed Karanashev on 01.08.2015.
 */
public class Time {
    private final long nanoTime;

    public Time() {
        this.nanoTime = 0;
    }

    public Time(long time, TimeUnit timeUnit) {
        nanoTime = timeUnit.toNanos(time);
    }

    public Time(long firstTime, TimeUnit firstTimeUnit, long secondTime, TimeUnit secondTimeUnit) {
        nanoTime = firstTimeUnit.toNanos(firstTime) +
                secondTimeUnit.toNanos(secondTime);
    }

}
