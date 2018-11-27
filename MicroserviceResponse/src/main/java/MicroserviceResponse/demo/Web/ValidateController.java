/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceResponse.demo.Web;

import MicroserviceResponse.demo.Entity.Response;
import MicroserviceResponse.demo.Service.DemandServiceClient;
import MicroserviceResponse.demo.Service.ResponseService;
import com.mycompany.common.DemandDto;
import com.mycompany.common.LoanDto;
import com.mycompany.common.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nasri
 */
@RestController
@RequestMapping("/validates")
public class ValidateController {

    private final ResponseService responseService;
    private final DemandServiceClient demandService;

    public ValidateController(ResponseService responseService, DemandServiceClient demandService) {
        this.responseService = responseService;
        this.demandService = demandService;
    }

  

    
    @GetMapping(path="/{id}")
    public ResponseDto getResponse(@PathVariable long id){
     return this.responseService.getResponse(id);
     
    }
    
    
    public ResponseDto Validate(DemandDto demand) {
        ResponseDto responseDto= this.responseService.studyDemand(demand);
        return responseDto;

    }
   @PostMapping
    public void handling(@RequestBody DemandDto demand) {
        ResponseDto response = Validate(demand);
        demand.setResponseId(response.getId());
       this.demandService.update(demand.getId(),response.getId());
        
    }

  
}
