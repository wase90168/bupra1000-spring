package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineCategory", types = { Category.class})
interface InlineCategory {

    Long getId();

    String getName();







}
