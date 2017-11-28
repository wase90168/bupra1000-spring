package at.fhjoanneum.ima15.bupa1000.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user_id",orphanRemoval = true)
    private List<User_Role> user_Roles;

    @Version
    private long version;

    public User() {
    }

    public User(String username, String password, List<User_Role> user_Roles, long version) {
        this.username = username;
        this.password = password;
        this.user_Roles = user_Roles;
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

    public List<User_Role> getUser_Roles() {
        return user_Roles;
    }

    public void setUser_Roles(List<User_Role> user_Roles) {
        this.user_Roles = user_Roles;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}