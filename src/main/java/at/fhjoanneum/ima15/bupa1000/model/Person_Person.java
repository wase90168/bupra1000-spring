package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person_Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Breastfeeding breastfeeding;

    @OneToOne(cascade = CascadeType.ALL)
    private Person mother;

    @OneToOne(cascade = CascadeType.ALL)
    private Person baby;

    public Person_Person() {
    }

    public Person_Person(List<Breastfeeding> breastfeedings, Person mother, Person baby, long version) {
        this.breastfeeding = breastfeeding;
        this.mother = mother;
        this.baby = baby;
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

    public void setBreastfeedings(Breastfeeding breastfeeding) {
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

    public void setBaby(Person baby_id) {
        this.baby = baby;
    }

}
