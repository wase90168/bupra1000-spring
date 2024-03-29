package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String character;

    private String type;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    //private List<Person> persons;


    public Type() {
    }

    public Type(String character, String type) {
        this.character = character;
        this.type = type;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
