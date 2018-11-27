package com.mycompany.common;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nasri
 */

@Data
@AllArgsConstructor
public class ClientDto implements Serializable {
    
    Long id ;
    String FirstName ;
    String LastName;
    LocalDateTime dateOfBirth ;
    int age ;
    String job ;
    double averageOfGainPerMonth ;
    String email ;
    long cin ;
    long phoneNumber ;
    AccountDto account;
    
}
