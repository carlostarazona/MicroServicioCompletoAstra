package pe.edu.upc.managementhservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ManagementhServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementhServiceApplication.class, args);
	}



}
