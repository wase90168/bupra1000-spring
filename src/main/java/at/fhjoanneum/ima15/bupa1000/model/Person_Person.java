package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;

@Entity
public class Person_Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Breastfeeding breastfeeding;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Person mother;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Person baby;

    @Version
    private long version;

    public Person_Person() {
    }

    public Person_Person(Breastfeeding breastfeeding, Person mother, Person baby, long version) {
        this.breastfeeding = breastfeeding;
        this.mother = mother;
        this.baby = baby;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Breastfeeding getBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(Breastfeeding breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getBaby() {
        return baby;
    }

    public void setBaby(Person baby) {
        this.baby = baby;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
