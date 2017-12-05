package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;

@Entity
public class Breastfeeding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "breastfeeding")
    private Person person;

    private boolean breastfeeding;

    private String description;

    @Version
    private long version;

    public Breastfeeding() {
    }

    public Breastfeeding(Person person, boolean breastfeeding, String description, long version) {
        this.person = person;
        this.breastfeeding = breastfeeding;
        this.description = description;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
