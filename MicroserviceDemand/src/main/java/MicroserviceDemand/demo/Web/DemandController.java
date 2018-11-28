/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceDemand.demo.Web;

import MicroserviceDemand.demo.Entity.Demand;
import MicroserviceDemand.demo.Service.DemandService;
import MicroserviceDemand.demo.Service.ResponseServiceClient;
import com.mycompany.common.ClientDto;
import com.mycompany.common.DemandDto;
import com.mycompany.common.ResponseDto;
import com.rabbitmq.client.AMQP.Access.Request;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author nasri
 */
@RestController
@RequestMapping("/demands")
public class DemandController {

    private final DemandService demandService;
    private final ResponseServiceClient responseServiceClient;

    public DemandController(DemandService demandService, ResponseServiceClient responseServiceClient) {
        this.demandService = demandService;
        this.responseServiceClient = responseServiceClient;
    }

    @GetMapping(value = "/all")
    public List<DemandDto> findAll() {

//ResponseEntity<List<ClientDto>> response = restTemplate.exchange(
//  "http://localhost:2222/clients",
//  HttpMethod.GET,
//  null,
//  new ParameterizedTypeReference<List<ClientDto>>(){});
// return response.getBody();
        return this.demandService.findAll();
    }

    @GetMapping(path = "/find/{id}")
    public Demand findById(@PathVariable Long id) {
        return this.demandService.findById(id);
    }
  
    @GetMapping(path = "/untraited")
    public  List<DemandDto> findAllUnprocessed(){
         return this.demandService.findAllUnprocessed();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void create(@RequestBody Demand demand) {
        this.demandService.create(demand);
    }

    @GetMapping(path = "/update/{demandId}/{responseId}")
    public void update(@PathVariable("demandId") Long demandId, @PathVariable("responseId") Long responseId) {
        this.demandService.update(demandId, responseId);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        this.demandService.delete(id);
    }

    @GetMapping(path = "/response/{id}") //DemandId 
    public ResponseDto getResponse(@PathVariable("id") long id) {
        if (this.demandService.isTraited(id)) {
            return this.responseServiceClient.getResponse(id);
        }
        return null;

    }

    @GetMapping(path = "/status/{id}")//DemandId 
    public Boolean isTraited(@PathVariable("id") Long id) {
        return this.demandService.isTraited(id);

    }

    @GetMapping(path = "/client/{id}")//clientId
    public List<DemandDto> findByClient(@PathVariable Long id) {
        return this.demandService.findByClient(id);
    }
}
