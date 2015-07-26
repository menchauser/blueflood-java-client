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
public class Ingester {

    private final String host;
    private final int ingestionPort;
    private final WebTarget target;

    public Ingester(String host) {
        this(host, "default");
    }

    public Ingester(String host, String tennant) {
        this(host, 19000, tennant);
    }

    public Ingester(String host, int ingestionPort, String tennant) {
        this.host = host;
        this.ingestionPort = ingestionPort;

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

    public IngestionStatus ingest(DataPoints dataPoints) {
        Response response = target.request().post(Entity.entity(dataPoints, MediaType.APPLICATION_JSON_TYPE));
        return response.getStatus() == Response.Status.OK.getStatusCode() ? IngestionStatus.OK : IngestionStatus.ERROR;
    }

    public enum IngestionStatus {
        OK, ERROR
    }
}
