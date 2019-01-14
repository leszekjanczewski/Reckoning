package pl.leszekjanczewski.reckoning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "pl.leszekjanczewski.reckoning.repository")
@SpringBootApplication
public class ReckoningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReckoningApplication.class, args);
	}

}