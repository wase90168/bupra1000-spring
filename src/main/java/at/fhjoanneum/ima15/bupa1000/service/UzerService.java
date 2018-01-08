package at.fhjoanneum.ima15.bupa1000.service;

import at.fhjoanneum.ima15.bupa1000.model.Role;
import at.fhjoanneum.ima15.bupa1000.model.RoleRepository;
import at.fhjoanneum.ima15.bupa1000.model.Uzer;
import at.fhjoanneum.ima15.bupa1000.model.UzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class UzerService {

    @Autowired
    private UzerRepository uzerRepository;

    @Autowired
    private RoleRepository roleRepository;



    @RequestMapping("/uzers/saveUzerWithRole")
    public void saveUzerWithRole(@Param("username") String username, @Param("password") String password){
        Uzer uzer = new Uzer();
        uzer.setUsername(username);
        uzer.setPassword(password);
        uzerRepository.save(uzer);
        uzer.setRoles(roleRepository.findAll());
        uzerRepository.save(uzer);
    }





}
