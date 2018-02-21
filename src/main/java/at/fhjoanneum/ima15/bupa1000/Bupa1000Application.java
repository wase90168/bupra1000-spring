package at.fhjoanneum.ima15.bupa1000;

import at.fhjoanneum.ima15.bupa1000.model.*;
import at.fhjoanneum.ima15.bupa1000.service.RestApiController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Bupa1000Application{





	public static void main(String[] args) {
		SpringApplication.run(Bupa1000Application.class, args);

	}



	@Bean
	public CommandLineRunner demo(ValueRepository valueRepository, RoleRepository roleRepository, UzerRepository uzerRepository, RestApiController uzerService, StateRepository stateRepository,
								  PersonRepository personRepository,
								  SourceRepository sourceRepository,
								  BiomarkerRepository biomarkerRepository,
								  MRRepository mrRepository) {
		return (args) -> {

			List<Uzer> uzers = new ArrayList<Uzer>();

			uzerService.saveUzerWithRole("John","Pa$$w0rd");

			uzerService.saveUzerWithRoleAdmin("admin","1234");

		};

		}


}
