package karanashev.blueflood.client.endpoints.query;

import java.util.Map;

/**
 * Created by Mukhamed Karanashev on 16.08.2015.
 */
public final class QueryValue<T> {

    private final int numPoints;
    private final long timestamp;
    private Map<SelectType, T> values;

    public QueryValue(int numPoints, long timestamp) {
        this.numPoints = numPoints;
        this.timestamp = timestamp;
    }

    public int numPoints() {
        return numPoints;
    }

    public long timestamp() {
        return timestamp;
    }

    public T valueFor(SelectType selectType) {
        return values.get(selectType);
    }
}
