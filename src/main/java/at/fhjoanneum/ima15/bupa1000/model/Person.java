package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String prefix;

    @Column(nullable = false)
    private String suffix;

    @ManyToOne
    private Type type;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Value> values;

    @OneToOne
    private  Person_Person person_person;

    public Person() {
    }

    public Person(String prefix, String suffix, Type type, List<Value> values, Person_Person person_person) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.type = type;
        this.values = values;
        this.person_person = person_person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public Person_Person getPerson_person() {
        return person_person;
    }

    public void setPerson_person(Person_Person person_person) {
        this.person_person = person_person;
    }
}
