package karanashev.blueflood.client.datetime;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mukhamed Karanashev on 01.08.2015.
 */
public class Time {
    private final long nanoTime;

    public Time(long time, TimeUnit timeUnit) {
        checkTimeValue(time, timeUnit);

        nanoTime = timeUnit.toNanos(time);
    }

    public Time(long firstTime, TimeUnit firstTimeUnit, long secondTime, TimeUnit secondTimeUnit) {
        checkTimeValue(firstTime, firstTimeUnit);
        checkTimeValue(secondTime, secondTimeUnit);

        nanoTime = firstTimeUnit.toNanos(firstTime) +
                secondTimeUnit.toNanos(secondTime);
    }

    public long seconds() {
        return TimeUnit.NANOSECONDS.toSeconds(nanoTime);
    }

    private void checkTimeValue(long time, TimeUnit timeUnit) {
        if (time < 0) {
            throw new IllegalArgumentException("Time value '" + time + "' for unit '" + timeUnit + "' cannot be negative");
        }
    }

    @Override
    public String toString() {
        return "Time{" +
                "nanoTime=" + nanoTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return nanoTime == time.nanoTime;

    }

    @Override
    public int hashCode() {
        return (int) (nanoTime ^ (nanoTime >>> 32));
    }
}
