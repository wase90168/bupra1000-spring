package at.fhjoanneum.ima15.bupa1000.model;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlinePerson", types = {Person.class})
interface InlinePerson {

    Long getId();

    String getPrefix();

    String getSuffix();

    Type getType();
}
