package at.fhjoanneum.ima15.bupa1000.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Uzer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    @JsonIgnore
    private String password;

    //@OneToMany(mappedBy = "user_id",orphanRemoval = true,cascade = CascadeType.ALL)
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "uzers")
    private List<Role> roles;


    public Uzer() {
    }

    public Uzer(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
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
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        this.password = hashedPassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = grantedAuthorities();

        return authorities;
    }


    public List<GrantedAuthority> grantedAuthorities()

    {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (Role role : getRoles())
        {
            GrantedAuthority grantedAuthority = AuthorityUtils.commaSeparatedStringToAuthorityList(role.getAuthority()).get(1);
            grantedAuthorityList.add(grantedAuthority);
        }
        return grantedAuthorityList;


    }
}