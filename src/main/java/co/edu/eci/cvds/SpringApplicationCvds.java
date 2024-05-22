package co.edu.eci.cvds;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class SpringApplicationCvds {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationCvds.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			System.out.println("Running...");
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
