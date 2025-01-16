package sncf.challenge.sncf.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SncfChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SncfChallengeApplication.class, args);
	}

}
