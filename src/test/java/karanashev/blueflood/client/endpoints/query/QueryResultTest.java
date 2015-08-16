package karanashev.blueflood.client.endpoints.query;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

/**
 * Author: Karanashev
 * Date: 16.08.15
 */
public class QueryResultTest {

    @Test
    public void okResultIsSuccessful() {
        QueryValues<BigDecimal> emptyValues = new QueryValues<>(Collections.<QueryValue<BigDecimal>>emptyList());
        QueryResult<BigDecimal> result = new QueryResult<>(QueryResult.QueryStatus.OK, emptyValues);

        assertTrue(result.isSuccessful());
    }

}
