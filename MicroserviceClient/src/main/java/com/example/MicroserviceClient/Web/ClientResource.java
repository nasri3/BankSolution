/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Web;

import com.example.MicroserviceClient.Entity.Client;
import com.example.MicroserviceClient.Service.ClientService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omar
 */
@RestController
@RequestMapping("/clients")
public class ClientResource {
    
    
    private final ClientService clientService ;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }
    
    
    
    
    
   @GetMapping
   public List<Client> findAll() {
       return clientService.findAll() ;
   }
   
   @PostMapping
   public void addClient(@RequestBody Client cl ) {
       clientService.addClient(cl) ;
   }
   
   @DeleteMapping(path="/{id}")
   public void delete (@PathVariable Long id) {
       clientService.removeClient(id)  ;
       
   }
   
   
    
}
