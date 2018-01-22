package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    //@OneToMany(mappedBy = "source",cascade = CascadeType.ALL)
    //private List<Value> values;



    public Source() {
    }

    public Source(String name) {
        this.name = name;

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


}
