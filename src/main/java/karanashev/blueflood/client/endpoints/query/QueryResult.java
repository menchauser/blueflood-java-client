package karanashev.blueflood.client.endpoints.query;

/**
 * Created by Mukhamed Karanashev on 16.08.2015.
 */
public final class QueryResult<T> {
    private final QueryStatus queryStatus;
    private final QueryValues<T> queryValues;

    public QueryResult(QueryStatus queryStatus, QueryValues<T> queryValues) {
        this.queryStatus = queryStatus;
        this.queryValues = queryValues;
    }

    public QueryStatus queryStatus() {
        return queryStatus;
    }

    public boolean isSuccessful() {
        return queryStatus() == QueryStatus.OK;
    }

    public QueryValues queryValues() {
        return queryValues;
    }

    public enum QueryStatus {
        OK, ERROR
    }
}
