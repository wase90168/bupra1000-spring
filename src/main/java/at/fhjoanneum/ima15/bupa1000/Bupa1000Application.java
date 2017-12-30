package at.fhjoanneum.ima15.bupa1000;

import at.fhjoanneum.ima15.bupa1000.model.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class Bupa1000Application{


	public static void main(String[] args) {
		SpringApplication.run(Bupa1000Application.class, args);

	}

	@Bean
	public CommandLineRunner demo(UzerRepository uzerRepository) {
		return (args) -> {
			//uzerRepository.save(new Uzer("John","Pa$$w0rd",roleRepository.findAll()));
			//uzerRepository.delete(1L);
		};

		}


}
