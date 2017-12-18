package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String description;

   // @OneToMany(mappedBy = "role_id",orphanRemoval = true,cascade = CascadeType.ALL)
   @ManyToMany
    private List<Uzer> uzers;


    public Role() {
    }

    public Role(String name, String description, List<Uzer> uzers, long version) {
        this.name = name;
        this.description = description;
        this.uzers = uzers;
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

    public List<Uzer> getUzers() {
        return uzers;
    }

    public void setUzers(List<Uzer> uzers) {
        this.uzers = uzers;
    }

  }
