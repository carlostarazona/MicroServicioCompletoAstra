package pe.edu.upc.technicalservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
@EnableDiscoveryClient
public class TechnicalServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TechnicalServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	// http://localhost:8080/swagger-ui/index.html?configUrl=/technical-api-docs/swagger-config
}
