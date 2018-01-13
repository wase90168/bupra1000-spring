package at.fhjoanneum.ima15.bupa1000.model;


import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineSource", types = {Source.class})
interface InlineSource {

    Long getId();

    String getName();

    List<Value> getValues();

}
