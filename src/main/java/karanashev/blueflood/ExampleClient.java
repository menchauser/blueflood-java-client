package karanashev.blueflood;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import karanashev.blueflood.client.*;
import karanashev.blueflood.client.json.DataPointsSerializer;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class ExampleClient {
    public static void main(String[] args) throws JsonProcessingException {
        DataPoints dataPoints = newDataPointsBatch();
        System.out.println("JSON to be sent: " + defaultObjectMapper().writeValueAsString(dataPoints));

        Ingester ingester =
                new LoggingIngester(
                        new ProfilingIngester(
                                new HttpIngester("127.0.0.1")));
        HttpIngester.IngestionStatus status = ingester.ingest(dataPoints);    }

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
