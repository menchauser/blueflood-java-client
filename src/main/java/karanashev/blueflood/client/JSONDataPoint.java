package karanashev.blueflood.client;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class JSONDataPoint {
    private final DataPoint dataPoint;

    public JSONDataPoint(DataPoint dataPoint) {
        this.dataPoint = dataPoint;
    }

    public DataPoint dataPoint() {
        return dataPoint;
    }

    public String jsonString() {
        ObjectMapper mapper = objectMapper();

        try {
            return mapper.writeValueAsString(dataPoint());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Cannot convert DataPoint " + dataPoint + " to JSON", e);
        }
    }

    private ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("DataPointModule", new Version(0, 0, 1, "SNAPSHOT", null, null));
        module.addSerializer(DataPoint.class, new JsonSerializer<DataPoint>() {
            @Override
            public void serialize(DataPoint dataPoint, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeNumberField("collectionTime", dataPoint.collectionTime().getMillis());
                jsonGenerator.writeNumberField("ttlInSeconds", dataPoint.ttlInSeconds());
                jsonGenerator.writeNumberField("metricValue", dataPoint.metricValue());
                jsonGenerator.writeStringField("metricName", dataPoint.metricName());
                jsonGenerator.writeEndObject();
            }
        });
        mapper.registerModule(module);
        return mapper;
    }

    @Override
    public String toString() {
        return jsonString();
    }
}
