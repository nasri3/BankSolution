/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Web;

import com.example.MicroserviceClient.Entity.Account;
import com.example.MicroserviceClient.Repsitory.AccountRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omar
 */
@RestController
@RequestMapping("/accounts")
public class AccountResource {
    private final AccountRepository accountRepository;

    public AccountResource(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @GetMapping
     List<Account> findAll(){
         return  this.accountRepository.findAll();
     }
    
}
