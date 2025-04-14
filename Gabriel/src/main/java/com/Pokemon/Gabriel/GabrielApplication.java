package com.Pokemon.Gabriel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.Pokemon.Gabriel")
@EntityScan(basePackages = {"com.Pokemon.Gabriel.domains", "com.Pokemon.Gabriel.domains.enums"})
@EnableJpaRepositories(basePackages = "com.Pokemon.Gabriel.repositories")

@SpringBootApplication
public class GabrielApplication {

	public static void main(String[] args) {
		SpringApplication.run(GabrielApplication.class, args);
	}

}
