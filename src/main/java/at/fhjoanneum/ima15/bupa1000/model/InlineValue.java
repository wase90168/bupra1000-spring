package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "inlineValue", types = { Value.class})
interface InlineValue {

    Long getId();

    BigDecimal getValue();

    State getState();

    Person getPerson();

    MR getMr();

    Source getSource();

    Dimension getDimension();


}

