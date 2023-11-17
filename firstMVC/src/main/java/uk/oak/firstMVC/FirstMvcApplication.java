package uk.oak.firstMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class FirstMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMvcApplication.class, args);
	}

}
