package at.fhjoanneum.ima15.bupa1000.service;

import at.fhjoanneum.ima15.bupa1000.model.Role;
import at.fhjoanneum.ima15.bupa1000.model.Uzer;
import at.fhjoanneum.ima15.bupa1000.model.UzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UzerLoginService implements UserDetailsService {

    @Autowired
    private UzerRepository uzerRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Uzer uzer = uzerRepository.findByUsername(username);
        if (uzer == null) {
            throw new NoSuchClientException("No user found with username: " + username);
        }
     List<GrantedAuthority> grantedAuthorities = grantedAuthorities(uzer);
        //List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");


        return new org.springframework.security.core.userdetails.User(uzer.getUsername(), uzer.getPassword(), grantedAuthorities);
    }

    public List<GrantedAuthority> grantedAuthorities(Uzer uzer)

    {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        for (Role role : uzer.getRoles())
        {
            GrantedAuthority grantedAuthority = AuthorityUtils.commaSeparatedStringToAuthorityList(role.getAuthority()).get(0);
            grantedAuthorityList.add(grantedAuthority);


        }

        return grantedAuthorityList;

    }



}
