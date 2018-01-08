package at.fhjoanneum.ima15.bupa1000;

import at.fhjoanneum.ima15.bupa1000.model.*;
import at.fhjoanneum.ima15.bupa1000.service.UzerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class Bupa1000Application{


	public static void main(String[] args) {
		SpringApplication.run(Bupa1000Application.class, args);

	}

    @RequestMapping("/csrf")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }

	//@Autowired
	//UzerRepository uzerRepository;

	@Bean
	public CommandLineRunner demo(RoleRepository roleRepository, UzerRepository uzerRepository, UzerService uzerService) {
		return (args) -> {




			uzerService.saveUzerWithRole("John","Pa$$w0rd");



			//uzerRepository.delete(2L);


			/*uzerRepository.save(uzer);

			uzer.setRoles(roleRepository.findAll());
			roleRepository.save(uzer.getRoles());

			/*Role role = roleRepository.findOne(1L);
			role.setUzers(role.addUzer(uzer));
			roleRepository.save(role);*/



			//uzerRepository.delete(1L);
		};

		}


}
