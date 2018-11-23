package MicroserviceDemand.demo;

import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MicroserviceDemandApplication {

	public static void main(String[] args) {
	  ApplicationContext ctx=SpringApplication.run(MicroserviceDemandApplication.class, args);
	  DemandRepository demandRepository =ctx.getBean(DemandRepository.class);
          ThingToBuyRepository thingToBuyRepository =ctx.getBean(ThingToBuyRepository.class);
          Stream.of("T1","T2","T3").forEach(s->thingToBuyRepository.save(new ThingToBuy(s,500)));
          thingToBuyRepository.findAll().forEach(s->demandRepository.save(new Demand(s.getId(),s)));
        }
}
