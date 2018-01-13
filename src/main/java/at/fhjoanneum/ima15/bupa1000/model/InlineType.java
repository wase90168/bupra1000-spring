package at.fhjoanneum.ima15.bupa1000.model;


import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineType", types = {Type.class})
interface InlineType {

    Long getId();

    String getCharacter();

    String getType();

    List<Person> getPersons();



}
