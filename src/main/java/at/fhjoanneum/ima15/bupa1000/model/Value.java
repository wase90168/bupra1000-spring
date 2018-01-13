package at.fhjoanneum.ima15.bupa1000.model;

import java.math.BigDecimal;


import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;


@Entity
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Digits(integer = 18, fraction = 20)
    private BigDecimal value;

    @ManyToOne
    private State state;

    @ManyToOne
    private Person person;

    @ManyToOne
    private MR mr;

    @ManyToOne
    private Source source;

    @ManyToOne
    private Dimension dimension;




    public Value() {
    }

    public Value(BigDecimal value, State state, Person person, MR mr, Source source, Dimension dimension, long version) {
        this.value = value;
        this.state = state;
        this.person = person;
        this.mr = mr;
        this.source = source;
        this.dimension = dimension;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public MR getMr() {
        return mr;
    }

    public void setMr(MR mr) {
        this.mr = mr;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

   
}