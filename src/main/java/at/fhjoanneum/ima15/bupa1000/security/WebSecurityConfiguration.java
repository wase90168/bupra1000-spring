package at.fhjoanneum.ima15.bupa1000.security;


import at.fhjoanneum.ima15.bupa1000.service.UzerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.RequestMethod;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationEntryPoint authEntryPoint;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http    .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home","/uzers/search/findByUsername","/createUzer","/saveUzerWithRole").permitAll()
                .antMatchers(HttpMethod.DELETE,"/values/**").access("hasRole('ADMIN')")
                .antMatchers("/categories","/states","/roles","/biomarkers","/types","/persons","/person_Persons","/mRs","/breastfeedings", "/dimensions","/sources").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    UzerLoginService uzerLoginService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(uzerLoginService)
                .passwordEncoder(passwordEncoder());

        //.inMemoryAuthentication()
          //      .withUser("user").password("password").roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


