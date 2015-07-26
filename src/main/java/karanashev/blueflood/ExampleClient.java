package karanashev.blueflood;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import karanashev.blueflood.client.DataPoints;
import karanashev.blueflood.client.Ingester;
import karanashev.blueflood.client.json.DataPointsSerializer;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class ExampleClient {
    public static void main(String[] args) throws JsonProcessingException {
        DataPoints dataPoints = newDataPointsBatch();
        System.out.println("Data Points to ingest: " + dataPoints);
        System.out.println("JSON to be sent: " + defaultObjectMapper().writeValueAsString(dataPoints));

        Ingester ingester = new Ingester("127.0.0.1");
        Ingester.IngestionStatus status = ingester.ingest(dataPoints);

        System.out.println("Ingestion status: " + status);
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
