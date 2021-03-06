package karanashev.blueflood.client.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import karanashev.blueflood.client.datetime.DefaultTimeInterval;
import karanashev.blueflood.client.endpoints.ingest.*;
import karanashev.blueflood.client.json.DataPointsSerializer;
import karanashev.blueflood.client.model.DataPoints;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class DemoClient {
    public static void main(String[] args) throws JsonProcessingException {
        DataPoints dataPoints = newDataPointsBatch();
        System.out.println("JSON to be sent: " + defaultObjectMapper().writeValueAsString(dataPoints));

        IngestionEndpoint ingestionEndpoint =
                new LoggingIngestionEndpoint(
                        new ProfilingIngestionEndpoint(
                                new HttpIngestionEndpoint("127.0.0.1")));
        IngestionResult result = ingestionEndpoint.ingest(dataPoints);
        if (result.isSuccessful()) {
            System.out.println("Successful ingestion");
        } else {
            System.out.println("Ingestion was unsuccessful");
        }
        System.out.println(result.message());
    }

    public static DataPoints newDataPointsBatch() {
        return new DataPoints().add(new DateTime(), DefaultTimeInterval.DAY.value(), new BigDecimal("54"), "example1.cpu");
    }

    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("DataPointsModule", new Version(0, 0, 1, "SNAPSHOT", "karanashev.blueflood-java-client", "blueflood-java-client"));
        module.addSerializer(DataPoints.class, new DataPointsSerializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }

}
