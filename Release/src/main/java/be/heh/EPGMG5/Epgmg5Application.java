package be.heh.EPGMG5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class Epgmg5Application {

	public static void main(String[] args) {
		SpringApplication.run(Epgmg5Application.class, args);
	}

}
