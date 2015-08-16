package karanashev.blueflood.client.endpoints.query;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.joda.time.DateTime;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

/**
 * Author: Karanashev
 * Date: 16.08.15
 */
public final class HttpQueryEndpoint implements QueryEndpoint<BigDecimal> {

    private final Client client;
    private final String host;
    private final int queryPort;
    private final String tennant;

    public HttpQueryEndpoint(String host, String tennant) {
        this(host, 20000, tennant);
    }

    public HttpQueryEndpoint(String host, int queryPort, String tennant) {
        client = defaultClient();
        this.host = host;
        this.queryPort = queryPort;
        this.tennant = tennant;
    }

    private Client defaultClient() {
        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        return client;
    }

    private String buildTargetString(String host, int queryPort) {
        return "http://" + host + ":" + queryPort
                + "/v2.0/:tennantId/views/:metric"
                + "?from=:from"
                + "?to=:to"
                + "?points=20"; // TODO: remove hardcode
    }

    @Override
    public QueryResult<BigDecimal> query(String metricName, DateTime from, DateTime to, int points) {
        WebTarget target = client.target(buildTargetString(host, queryPort))
                .queryParam("tennantId", tennant)
                .queryParam("metric", metricName)
                .queryParam("from", from.getMillis())
                .queryParam("to", to.getMillis());
        // TODO: parse response
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        return new QueryResult<>(QueryResult.QueryStatus.OK, new QueryValues<BigDecimal>());
    }
}
