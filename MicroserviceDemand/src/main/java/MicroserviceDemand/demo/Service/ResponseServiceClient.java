/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceDemand.demo.Service;

import com.mycompany.common.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nasri
 */
@FeignClient(name = "muresponse",url="http://localhost:4444")
public interface ResponseServiceClient {
    @RequestMapping(value = "/validates/{demandId}",method = RequestMethod.GET )
    public ResponseDto getResponse(@PathVariable long demandId);
}
