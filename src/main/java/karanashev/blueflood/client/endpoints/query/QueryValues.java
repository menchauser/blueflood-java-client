package karanashev.blueflood.client.endpoints.query;

import java.util.Collections;
import java.util.List;

/**
 * Created by Mukhamed Karanashev on 16.08.2015.
 */
public final class QueryValues<T> {
    private final List<QueryValue<T>> queryValues;

    public QueryValues() {
        this.queryValues = Collections.emptyList();
    }

    public QueryValues(List<QueryValue<T>> queryValues) {
        this.queryValues = queryValues;
    }

    public Iterable<QueryValue<T>> values() {
        return queryValues;
    }

}
