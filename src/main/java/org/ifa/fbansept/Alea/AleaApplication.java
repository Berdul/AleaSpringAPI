package org.ifa.fbansept.Alea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AleaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AleaApplication.class, args);
	}

}
