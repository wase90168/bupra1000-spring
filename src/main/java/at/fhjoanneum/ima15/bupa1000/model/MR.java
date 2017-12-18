package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class MR {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String shortName;

    private String name;

    @OneToMany(mappedBy = "mr",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Value> values;

    public MR() {
    }

    public MR(String shortName, String name, List<Value> values, long version) {
        this.shortName = shortName;
        this.name = name;
        this.values = values;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}
