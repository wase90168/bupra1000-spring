package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;


@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "mother_id"),
                @UniqueConstraint(columnNames = "baby_id")
        }
)
@Entity
public class Person_Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Breastfeeding breastfeeding;

    @ManyToOne
    private Person mother;

    @ManyToOne
    private Person baby;

    public Person_Person() {
    }


    public Person_Person(Breastfeeding breastfeeding, Person mother, Person baby) {
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

}
