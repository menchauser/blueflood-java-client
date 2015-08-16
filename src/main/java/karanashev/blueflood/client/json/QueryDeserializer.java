package karanashev.blueflood.client.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import karanashev.blueflood.client.endpoints.query.QueryValue;
import karanashev.blueflood.client.endpoints.query.QueryValues;
import karanashev.blueflood.client.endpoints.query.SelectType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Author: Karanashev
 * Date: 16.08.15
 */
public class QueryDeserializer extends JsonDeserializer<QueryValues<BigDecimal>> {

    @Override
    public QueryValues<BigDecimal> deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        TreeNode root = parser.getCodec().readTree(parser);
        ArrayNode jsonValues = (ArrayNode) root.get("values");
        List<QueryValue<BigDecimal>> result = new ArrayList<>();
        for (JsonNode jsonValue : jsonValues) {
            int numPoints = jsonValue.get("numPoints").asInt();
            long timestamp = jsonValue.get("timestamp").asLong();
            BigDecimal averageValue = jsonValue.get("average").decimalValue();
            Map<SelectType, BigDecimal> actualValues = Collections.singletonMap(SelectType.AVERAGE, averageValue);
            QueryValue<BigDecimal> queryValue = new QueryValue<>(numPoints, timestamp, actualValues);
            result.add(queryValue);
        }
        return new QueryValues<>(result
        );
    }
}
