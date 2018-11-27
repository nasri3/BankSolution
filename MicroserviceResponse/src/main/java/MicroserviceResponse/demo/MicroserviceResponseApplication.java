package MicroserviceResponse.demo;

import MicroserviceResponse.demo.Entity.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MicroserviceResponseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceResponseApplication.class, args);
                
	}
}
