package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineUzer", types = {Uzer.class})
interface InlineUzer {

    Long getId();

    String getUsername();

    //String getPassowrd();

    


}
