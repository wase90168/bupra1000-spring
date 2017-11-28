package at.fhjoanneum.ima15.bupa1000.model;


import javax.persistence.*;

@Entity
public class User_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user_id;

    @ManyToOne
    private Role role_id;

    @Version
    private long version;

    public User_Role() {
    }

    public User_Role(User user_id, Role role_id, long version) {
        this.user_id = user_id;
        this.role_id = role_id;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}

