package karanashev.blueflood.client.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import karanashev.blueflood.client.DataPoint;
import karanashev.blueflood.client.DataPoints;

import java.io.IOException;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public class DataPointsSerializer extends JsonSerializer<DataPoints> {

    @Override
    public void serialize(DataPoints dataPoints, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();

        for (DataPoint dataPoint : dataPoints) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("collectionTime", dataPoint.collectionTime().getMillis());
            jsonGenerator.writeNumberField("ttlInSeconds", dataPoint.ttlInSeconds());
            jsonGenerator.writeNumberField("metricValue", dataPoint.metricValue());
            jsonGenerator.writeStringField("metricName", dataPoint.metricName());
            jsonGenerator.writeEndObject();
        }

        jsonGenerator.writeEndArray();
    }

}
