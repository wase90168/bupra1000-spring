package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class MR {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;

    //@OneToMany(mappedBy = "mr",cascade = CascadeType.ALL)
    //private List<Value> values;

    public MR() {
    }

    public MR(String name, String description, List<Value> values) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
