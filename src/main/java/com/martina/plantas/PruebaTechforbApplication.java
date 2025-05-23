package com.martina.plantas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PruebaTechforbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTechforbApplication.class, args);
	}

}
