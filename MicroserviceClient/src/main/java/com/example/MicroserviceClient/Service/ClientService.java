/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Service;

import com.example.MicroserviceClient.Repsitory.ClientRepository;
import com.example.MicroserviceClient.Entity.Client;
import com.mycompany.common.AccountDto;
import com.mycompany.common.ClientDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author omar
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class ClientService {

    private final ClientRepository clientRepository;

public  ClientDto findById(long id){
    return mapToDto( this.clientRepository.findById(id)
              .orElseThrow(() -> new IllegalStateException("Cannot find client with id " + id)));

}
    
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
         .stream()
        .map(ClientService::mapToDto)
        .collect(Collectors.toList());
    }

    public Client addClient(Client cl) {
        return clientRepository.save(cl);
    }

    public void removeClient(Long id) {
        clientRepository.deleteById(id);
    }

    public static ClientDto mapToDto(Client client) {
        if (client != null) {
            return new ClientDto(client.getId(), client.getFirstName(),
                     client.getLastName(),
                    client.getDateOfBirth(), client.getAge(),
                    client.getJob(),client.getAverageOfGainPerMonth(),
                    client.getEmail(), client.getCin(), client.getPhoneNumber(),
                    new AccountDto(client.getId(), client.getAccount().getTypeOfAccount().toString(), 0));
        }
        return null;
    }
}
