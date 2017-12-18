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
    private Person mother_id;

    @OneToOne(cascade = CascadeType.ALL)
    private Person baby_id;

    public Person_Person() {
    }

    public Person_Person(List<Breastfeeding> breastfeedings, Person mother_id, Person baby_id, long version) {
        this.breastfeeding = breastfeeding;
        this.mother_id = mother_id;
        this.baby_id = baby_id;
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

    public Person getMother_id() {
        return mother_id;
    }

    public void setMother_id(Person mother_id) {
        this.mother_id = mother_id;
    }

    public Person getBaby_id() {
        return baby_id;
    }

    public void setBaby_id(Person baby_id) {
        this.baby_id = baby_id;
    }

}
