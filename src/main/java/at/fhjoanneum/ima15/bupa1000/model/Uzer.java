package at.fhjoanneum.ima15.bupa1000.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Uzer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    @JsonIgnore
    private String password;

    //@OneToMany(mappedBy = "user_id",orphanRemoval = true,cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "uzers"
            /*cascade = CascadeType.ALL*/)
    private List<Role> roles;

    @Version
    private long version;

    public Uzer() {
    }

    public Uzer(String username, String password, List<Role> roles, long version) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.version = version;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}