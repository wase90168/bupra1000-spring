package at.fhjoanneum.ima15.bupa1000.model;


import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineRole", types = {Role.class})
interface InlineRole {

    Long getId();

    String getName();

    String getDescription();

    List<Uzer> getUzers();
}
