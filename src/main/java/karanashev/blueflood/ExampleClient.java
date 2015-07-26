package karanashev.blueflood;

import com.fasterxml.jackson.core.JsonProcessingException;
import karanashev.blueflood.client.DataPoint;
import karanashev.blueflood.client.JSONDataPoint;
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
        DataPoint dataPoint = newDataPoint();
        System.out.println("Data Point to ingest: " + dataPoint);
        JSONDataPoint jsonDataPoint = new JSONDataPoint(dataPoint);
        System.out.println("JSON data point: " + jsonDataPoint);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://127.0.0.1:19000/v2.0/:tennantId/ingest");
        target.queryParam("tennantId", "extennant1");
        Invocation.Builder request = target.request();
        System.out.println("URI: " + target.getUri());

        Response response = request.post(Entity.entity(jsonDataPoint.jsonString(), MediaType.APPLICATION_JSON_TYPE));
        System.out.println("Response status code: " + response.getStatus());
        System.out.println("Response status: " + response.getStatusInfo());
    }

    public static DataPoint newDataPoint() {
        return new DataPoint(new DateTime(), 60 * 60 * 24, new BigDecimal("54.5"), "example1.cpu");
    }

}
