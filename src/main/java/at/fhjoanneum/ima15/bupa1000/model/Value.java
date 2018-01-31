package at.fhjoanneum.ima15.bupa1000.model;

import at.fhjoanneum.ima15.bupa1000.service.JsonValueSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.internal.Nullable;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@JsonAutoDetect
@Entity
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Digits(integer = 18, fraction = 20)
    @JsonSerialize(using = JsonValueSerializer.class)
    @Nullable
    private BigDecimal value;

    @ManyToOne
    private State state;

    @ManyToOne(fetch = FetchType.EAGER)
    @Nullable
    private Person person;

    @ManyToOne
    @Nullable
    private MR mr;

    @ManyToOne
    @Nullable
    private Source source;

    @ManyToOne
    @Nullable
    private Dimension dimension;


    public Value() {
    }

    public Value(BigDecimal value, State state, Person person, MR mr, Source source, Dimension dimension) {
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