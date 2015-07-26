package karanashev.blueflood.client.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import karanashev.blueflood.client.DataPoints;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
@Provider
public class JacksonConfiguration implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public JacksonConfiguration() {
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("DataPointsModule", new Version(0, 0, 1, "SNAPSHOT", "karanashev.blueflood-java-client", "blueflood-java-client"));
        module.addSerializer(DataPoints.class, new DataPointsSerializer());
        objectMapper.registerModule(module);
    }

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return objectMapper;
    }
}
