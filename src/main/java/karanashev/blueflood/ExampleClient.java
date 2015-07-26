package karanashev.blueflood;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import karanashev.blueflood.client.DataPoints;
import karanashev.blueflood.client.json.DataPointsSerializer;
import karanashev.blueflood.client.json.JacksonConfiguration;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.joda.time.DateTime;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class ExampleClient {
    public static void main(String[] args) throws JsonProcessingException {
        DataPoints dataPoints = newDataPointsBatch();
        System.out.println("Data Points to ingest: " + dataPoints);
        System.out.println("JSON to be sent: " + defaultObjectMapper().writeValueAsString(dataPoints));

        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        client.register(JacksonConfiguration.class);
        WebTarget target = client.target("http://127.0.0.1:19000/v2.0/:tennantId/ingest");
        target.queryParam("tennantId", "extennant1");
        Invocation.Builder request = target.request();
        System.out.println("URI: " + target.getUri());

        Response response = request.post(Entity.entity(dataPoints, MediaType.APPLICATION_JSON_TYPE));
        System.out.println("Response status code: " + response.getStatus());
        System.out.println("Response status: " + response.getStatusInfo());
    }

    public static DataPoints newDataPointsBatch() {
        return new DataPoints().add(new DateTime(), 60 * 60 * 24, new BigDecimal("54"), "example1.cpu");
    }

    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("DataPointsModule", new Version(0, 0, 1, "SNAPSHOT", "karanashev.blueflood-java-client", "blueflood-java-client"));
        module.addSerializer(DataPoints.class, new DataPointsSerializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }

}
