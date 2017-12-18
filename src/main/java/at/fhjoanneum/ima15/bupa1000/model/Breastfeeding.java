package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;

@Entity
public class Breastfeeding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "breastfeeding")
    private List<Person_Person> person_persons;

    private Boolean breastfeeding;

    private String description;

    public Breastfeeding() {
    }

    public Breastfeeding(List<Person_Person> person_persons, boolean breastfeeding, String description, long version) {
        this.person_persons = person_persons;
        this.breastfeeding = breastfeeding;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Person_Person> getPerson_persons() {
        return person_persons;
    }

    public void setPerson_persons(List<Person_Person> person_persons) {
        this.person_persons = person_persons;
    }

    public boolean isBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(boolean breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
