package karanashev.blueflood.client.endpoints.query;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Author: Karanashev
 * Date: 16.08.15
 */
public final class HttpQueryEndpoint implements QueryEndpoint<BigDecimal> {

    @Override
    public QueryResult<BigDecimal> query(String metricName, DateTime from, DateTime to, int points) {
        return new QueryResult<>(QueryResult.QueryStatus.OK, new QueryValues<BigDecimal>());
    }
}
