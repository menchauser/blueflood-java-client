package karanashev.blueflood.client.endpoints.query;

import org.joda.time.DateTime;

import javax.annotation.Nonnull;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public interface QueryEndpoint<T> {

    @Nonnull
    QueryResult<T> query(String metricName, DateTime from, DateTime to, int points);

    // TODO: add querying with 'select' option
}
