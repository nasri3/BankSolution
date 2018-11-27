/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Entity;

import com.example.MicroserviceClient.Entity.Enumeration.TypeOfAccount;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author omar
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    TypeOfAccount typeOfAccount ;
    
    @NotNull
    @Column( precision = 10)
    double amount ;
    

    public Account() {
        //voila bb ce constructeur n est pas vide.
    }

    public Account( TypeOfAccount typeOfAccount, double amount) {
        this.typeOfAccount = typeOfAccount;
        this.amount = amount;
    }
    
  

    

   


    
    

    
    
    
            
    
}
