package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineUzer", types = {Uzer.class})
interface InlineUzer {

    Long getId();

    String getUsername();

    List<Role> getRoles();




}
