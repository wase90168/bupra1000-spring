package at.fhjoanneum.ima15.bupa1000;

import at.fhjoanneum.ima15.bupa1000.model.*;
import at.fhjoanneum.ima15.bupa1000.service.RestApiController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;




@SpringBootApplication
public class Bupa1000Application{





	public static void main(String[] args) {
		SpringApplication.run(Bupa1000Application.class, args);

	}



	@Bean
	public CommandLineRunner demo(ValueRepository valueRepository, RoleRepository roleRepository, UzerRepository uzerRepository, RestApiController uzerService, StateRepository stateRepository,
								  PersonRepository personRepository,
								  SourceRepository sourceRepository,
								  DimensionRepository dimensionRepository,
								  MRRepository mrRepository) {
		return (args) -> {




			uzerService.saveUzerWithRole("John","Pa$$w0rd");

			//System.out.print(valueRepository.findAllByPerson_PrefixAndPerson_Suffix("4444","0001"));


			/*Value value = new Value(new BigDecimal(666),stateRepository.findOne(1L),personRepository.findOne(1L),mrRepository.findOne(1L),sourceRepository.findOne(1L),dimensionRepository.findOne(1L));
			valueRepository.save(value);
			value = valueRepository.findById(31L);
			value.setPerson(personRepository.findOne(20L));
			valueRepository.save(value);

			valueRepository.delete(1L);*/





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
