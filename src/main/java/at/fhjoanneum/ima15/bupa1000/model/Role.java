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
   @ManyToMany(mappedBy = "roles",
           cascade = CascadeType.ALL)
    private List<User> users;

    @Version
    private long version;

    public Role() {
    }

    public Role(String name, String description, List<User> users, long version) {
        this.name = name;
        this.description = description;
        this.users = users;
        this.version = version;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
