package karanashev.blueflood.client.datetime;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mukhamed Karanashev on 01.08.2015.
 */
public enum DefaultTimeInterval {
    HOUR(new TimeInterval(1, TimeUnit.HOURS)),
    DAY(new TimeInterval(1, TimeUnit.DAYS)),
    WEEK(new TimeInterval(7, TimeUnit.DAYS)),
    MONTH(new TimeInterval(30, TimeUnit.DAYS));

    private final TimeInterval timeInterval;

    DefaultTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public TimeInterval value() {
        return timeInterval;
    }
}
