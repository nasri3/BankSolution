/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Entity;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String FirstName ;
    String LastName;
    LocalDateTime dateOfBirth ;
    int age ;
    String job ;
    double averageOfGainPerMonth ;
    //@Email
    String email ;
    @NotNull
    long cin ;
    long phoneNumber ;
    
    @OneToOne
    Account account;

    public Client(String FirstName, String LastName, LocalDateTime dateOfBirth, int age, String job, double averageOfGainPerMonth, String email, long cin, long phoneNumber, Account account) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.job = job;
        this.averageOfGainPerMonth = averageOfGainPerMonth;
        this.email = email;
        this.cin = cin;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public Client() {
        //for JPA
    }

 
    
}
