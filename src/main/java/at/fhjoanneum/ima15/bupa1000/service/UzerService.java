package at.fhjoanneum.ima15.bupa1000.service;

import at.fhjoanneum.ima15.bupa1000.model.Role;
import at.fhjoanneum.ima15.bupa1000.model.RoleRepository;
import at.fhjoanneum.ima15.bupa1000.model.Uzer;
import at.fhjoanneum.ima15.bupa1000.model.UzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UzerService implements UserDetailsService {

    @Autowired
    private UzerRepository uzerRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Uzer uzer = uzerRepository.findByUsername(username);
        if (uzer == null) {
            throw new NoSuchClientException("No user found with username: " + username);
        }


        List<GrantedAuthority> grantedAuthorities = uzer.getAuthorities();

        String password = uzer.getPassword();
        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }

    public void saveUzerWithRole(Uzer uzer){
        uzerRepository.save(uzer);
        Role role = roleRepository.findRoleByName("ROLE_USER");
        role.setUzers(role.addUzer(uzer));
        roleRepository.save(role);
    }



}
