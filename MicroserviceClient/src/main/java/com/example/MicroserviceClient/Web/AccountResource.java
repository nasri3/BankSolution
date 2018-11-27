/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Web;

import com.example.MicroserviceClient.Entity.Account;
import com.example.MicroserviceClient.Repsitory.AccountRepository;
import com.example.MicroserviceClient.Service.AccountService;
import com.mycompany.common.AccountDto;
import java.util.List;
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
@RequestMapping("/accounts")
public class AccountResource {
    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

  
    @GetMapping
    public List<AccountDto> findAll() {
        return this.accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountDto findById(@PathVariable Long id) {
        return this.accountService.findById(id);
    }

    @PostMapping
    public AccountDto create(@RequestBody AccountDto accountDto) {
        return this.accountService.create(accountDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.accountService.delete(id);
    }
    
}
