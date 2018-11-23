package com.example.MicroserviceClient;



import com.example.MicroserviceClient.Entity.Account;
import com.example.MicroserviceClient.Entity.Bank;
import com.example.MicroserviceClient.Entity.Client;
import com.example.MicroserviceClient.Repsitory.AccountRepository;
import com.example.MicroserviceClient.Repsitory.BankRepository;
import com.example.MicroserviceClient.Repsitory.ClientRepository;
import com.netflix.client.ClientRequest;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceClientApplication {

	public static void main(String[] args) {
	           ApplicationContext ctx=  SpringApplication.run(MicroserviceClientApplication.class, args);
                   ClientRepository clientRepository =ctx.getBean(ClientRepository.class);
                   AccountRepository accountRepository =ctx.getBean(AccountRepository.class);
                   BankRepository  bankRepository =ctx.getBean(BankRepository.class);
                   Stream.of("A1","A2","A3").forEach(s->accountRepository.save(new Account(s)));
                   accountRepository.findAll().forEach(s->clientRepository.save(new Client("A"+s.getId(),s)));
                   
                         
	}
}
