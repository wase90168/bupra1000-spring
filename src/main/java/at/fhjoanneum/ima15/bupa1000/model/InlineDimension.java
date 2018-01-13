package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineDimension", types = {Dimension.class})
interface InlineDimension
{
    Long getId();

    String getName();

    String getDimension();

    String getDescription();

    Category getCategory();

    List<Value> getValues();


}
