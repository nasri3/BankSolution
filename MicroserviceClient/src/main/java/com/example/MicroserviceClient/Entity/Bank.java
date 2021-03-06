/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    
    String name ;
    
    @OneToMany
     List<Account> accounts;       
    
    @NotNull
    @Column( precision = 10)
    double capital ;

    public Bank() {
        //for JPA
    }

    public Bank(String name, List<Account> accounts, double capital) {
        this.name = name;
        this.accounts = accounts;
        this.capital = capital;
    }
 
            
            
}
