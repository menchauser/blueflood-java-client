package karanashev.blueflood;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class ExampleClient {
    public static void main(String[] args) throws JsonProcessingException {
        String metricString = prepareMetric();
        System.out.println("Metric to ingest: " + metricString);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://127.0.0.1:19000/v2.0/:tennantId/ingest");
        target.queryParam("tennantId", "extennant1");
        Invocation.Builder request = target.request();
        System.out.println("URI: " + target.getUri());

        Response response = request.post(Entity.entity(metricString, MediaType.APPLICATION_JSON_TYPE));
        System.out.println("Response status code: " + response.getStatus());
        System.out.println("Response status: " + response.getStatusInfo());
    }

    public static String prepareMetric() throws JsonProcessingException {
        Map<String, Object> object = new HashMap<>();
        object.put("collectionTime", new Date().getTime());
        object.put("ttlInSeconds", 60 * 60 * 24);
        object.put("metricValue", 46);
        object.put("metricName", "example.cpu");

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(Collections.singleton(object));
    }
}
