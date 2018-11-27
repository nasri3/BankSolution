package MicroserviceResponse.demo;

import MicroserviceResponse.demo.Entity.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MicroserviceResponseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceResponseApplication.class, args);
                
	}
}
