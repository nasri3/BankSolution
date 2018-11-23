package Conf_Service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfServiceApplication.class, args);
	}
}
