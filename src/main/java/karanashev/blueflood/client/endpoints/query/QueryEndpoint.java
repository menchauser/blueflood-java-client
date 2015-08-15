package karanashev.blueflood.client.endpoints.query;

import org.joda.time.DateTime;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public interface QueryEndpoint {
    // TODO: implement type
    public Object query(String metricName, DateTime from, DateTime to);
}
