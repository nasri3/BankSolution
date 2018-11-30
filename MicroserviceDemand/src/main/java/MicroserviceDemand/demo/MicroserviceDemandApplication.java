package MicroserviceDemand.demo;

import MicroserviceDemand.demo.Entity.Demand;
import MicroserviceDemand.demo.Entity.ThingToBuy;
import MicroserviceDemand.demo.Repository.ThingToBuyRepository;
import MicroserviceDemand.demo.Repository.DemandRepository;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MicroserviceDemandApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MicroserviceDemandApplication.class, args);
        DemandRepository demandRepository = ctx.getBean(DemandRepository.class);
        ThingToBuyRepository thingToBuyRepository = ctx.getBean(ThingToBuyRepository.class);
        Stream.of(200, 600, 800).forEach(s -> thingToBuyRepository.save(
                new ThingToBuy("s", "s", s)));
        List<ThingToBuy> l = thingToBuyRepository.findAll();
        Demand c1=new Demand(10, 1, l.get(0));
        demandRepository.save(c1);
        demandRepository.save(new Demand(100000, 2, l.get(1)));
        demandRepository.save(new Demand(100, 3, l.get(2)));

    }

  
}
