package karanashev.blueflood.client;

import karanashev.blueflood.client.json.JacksonConfiguration;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class HttpIngester implements Ingester {

    private final WebTarget target;

    public HttpIngester(String host) {
        this(host, "default");
    }

    public HttpIngester(String host, String tennant) {
        this(host, 19000, tennant);
    }

    public HttpIngester(String host, int ingestionPort, String tennant) {
        target = defaultClient().target(buildTargetString(host, ingestionPort));
        target.queryParam("tennantId", tennant);
    }

    private Client defaultClient() {
        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        client.register(JacksonConfiguration.class);
        return client;
    }

    private String buildTargetString(String host, int ingestionPort) {
        return "http://" + host + ":" + ingestionPort + "/v2.0/:tennantId/ingest";
    }

    @Override
    public IngestionStatus ingest(DataPoints dataPoints) {
        Response response = target.request().post(Entity.entity(dataPoints, MediaType.APPLICATION_JSON_TYPE));
        return response.getStatusInfo() == Response.Status.OK ? IngestionStatus.OK : IngestionStatus.ERROR;
    }

}
