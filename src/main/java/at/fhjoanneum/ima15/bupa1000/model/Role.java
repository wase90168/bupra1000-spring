package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Role implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    private String description;

   // @OneToMany(mappedBy = "role_id",orphanRemoval = true,cascade = CascadeType.ALL)
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Uzer> uzers;


    public Role() {
    }

    public Role(String name, String description, List<Uzer> uzers) {
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

    @Override
    public String getAuthority() {
        return name;
    }
}
