/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Repsitory;
import com.example.MicroserviceClient.Entity.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omar
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    

} 
    
