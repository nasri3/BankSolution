package MicroserviceResponse.demo.Service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nasri
// */
@FeignClient(name = "responseClient",url="http://localhost:3333")
public interface DemandServiceClient {
    @RequestMapping(path = "/demands/update/{demandId}/{responseId}", method = RequestMethod.GET) 
    public void update(@PathVariable("demandId") Long demandId,@PathVariable("responseId") Long responseId);
        
    
}
