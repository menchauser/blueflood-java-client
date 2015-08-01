package karanashev.blueflood.client.datetime;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mukhamed Karanashev on 01.08.2015.
 */
public enum DefaultTimeInterval {
    HOUR(new Time(1, TimeUnit.HOURS)),
    DAY(new Time(1, TimeUnit.DAYS)),
    WEEK(new Time(7, TimeUnit.DAYS)),
    MONTH(new Time(30, TimeUnit.DAYS));

    private final Time timeInterval;

    DefaultTimeInterval(Time timeInterval) {
        this.timeInterval = timeInterval;
    }

    public Time value() {
        return timeInterval;
    }
}
