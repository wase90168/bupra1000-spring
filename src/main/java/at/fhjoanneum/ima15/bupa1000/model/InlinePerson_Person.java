package at.fhjoanneum.ima15.bupa1000.model;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlinePerson_Person", types ={Person_Person.class})
interface InlinePerson_Person {

    Long getId();

    Breastfeeding getBreastfeeding();

    Person getMother();

    Person getBaby();


}
