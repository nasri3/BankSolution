package com.example.MicroserviceClient;



import com.example.MicroserviceClient.Entity.Account;
import com.example.MicroserviceClient.Entity.Bank;
import com.example.MicroserviceClient.Entity.Client;
import com.example.MicroserviceClient.Entity.Enumeration.TypeOfAccount;
import com.example.MicroserviceClient.Repsitory.AccountRepository;
import com.example.MicroserviceClient.Repsitory.BankRepository;
import com.example.MicroserviceClient.Repsitory.ClientRepository;
import com.netflix.client.ClientRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceClientApplication {

	public static void main(String[] args) {
	           ApplicationContext ctx=  SpringApplication.run(MicroserviceClientApplication.class, args);
                   ClientRepository clientRepository =ctx.getBean(ClientRepository.class);
                   AccountRepository accountRepository =ctx.getBean(AccountRepository.class);
                   BankRepository  bankRepository =ctx.getBean(BankRepository.class);
                   Stream.of(500,100,200).forEach(s->accountRepository.save(new Account(TypeOfAccount.CURRENT, s)));
                    List<Account> accounts= accountRepository.findAll();
                  Client c1=  new Client("Ali", "jaziri", LocalDateTime.MIN, 20, "tt", 400, "email", 456, 0, accounts.get(0));
                  Client c2=   new Client("Hedi", "chouchene", LocalDateTime.MIN, 30, "cc", 1000, "email", 456, 0, accounts.get(1));
                  Client c3=   new Client("Rami", "bensalha", LocalDateTime.MIN, 33, "vv", 600, "email", 456, 0, accounts.get(2));
                   clientRepository.save(c1);clientRepository.save(c2);clientRepository.save(c3);
                         
	}
}
