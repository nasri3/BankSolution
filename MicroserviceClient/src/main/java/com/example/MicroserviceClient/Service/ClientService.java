/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Service;

import com.example.MicroserviceClient.Repsitory.ClientRepository;
import com.example.MicroserviceClient.Entity.Client;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author omar
 */
@Service
public class ClientService {
    
    private final ClientRepository clientRepository ;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    public List<Client> findAll() {
        return clientRepository.findAll() ;
    }
    
    public Client addClient(Client cl) {
        return clientRepository.save(cl) ;
    }
    
    public void removeClient(Long id ){
        clientRepository.deleteById(id);
    }
    
}
