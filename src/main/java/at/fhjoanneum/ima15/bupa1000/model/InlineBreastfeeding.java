package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineBreastfeeding", types = { Breastfeeding.class})
interface InlineBreastfeeding {

    Long getId();

    List<Person_Person> getPerson_persons();

    boolean getBreastfeeding();

    String getDescription();








}
