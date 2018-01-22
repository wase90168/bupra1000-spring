package at.fhjoanneum.ima15.bupa1000.service;

import at.fhjoanneum.ima15.bupa1000.model.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class JsonValueSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider provider)
            throws IOException, JsonProcessingException {


        String formattedValue = value.toString();
        gen.writeString(formattedValue);
    }
}
