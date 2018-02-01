package at.fhjoanneum.ima15.bupa1000.model;

import at.fhjoanneum.ima15.bupa1000.service.JsonValueSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "inlineValue", types = { Value.class})
interface InlineValue {

    Long getId();

    @JsonSerialize(using = JsonValueSerializer.class)
    BigDecimal getValue();

    State getState();

    Person getPerson();

    MR getMr();

    Source getSource();

    Biomarker getBiomarker();

    Dimension getDimension();

    Comment getComment();


}

