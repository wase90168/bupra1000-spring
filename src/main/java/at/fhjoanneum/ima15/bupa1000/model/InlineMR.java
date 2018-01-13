package at.fhjoanneum.ima15.bupa1000.model;


import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineMr", types = {MR.class})
interface InlineMR {

    Long getId();

    String getName();

    String getDescription();

    List<Value> getValues();
}
