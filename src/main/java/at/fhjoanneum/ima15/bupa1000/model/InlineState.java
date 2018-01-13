package at.fhjoanneum.ima15.bupa1000.model;


import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineState", types = {Type.class})
interface InlineState {

    Long getId();

    String getText();

    String getDescription();

    boolean isNull_allowed();

    List<Value> getValues();

}
