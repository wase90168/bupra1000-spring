package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;

@Entity
public class Breastfeeding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "breastfeeding")
    //private List<Person_Person> person_persons;

    private boolean breastfeeding;

    private String description;

    public Breastfeeding() {
    }

    public Breastfeeding(boolean breastfeeding, String description, long version) {
        this.breastfeeding = breastfeeding;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
