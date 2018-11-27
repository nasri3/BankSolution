/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Service;

import com.example.MicroserviceClient.Entity.Account;
import com.example.MicroserviceClient.Entity.Enumeration.TypeOfAccount;
import com.example.MicroserviceClient.Repsitory.AccountRepository;
import com.mycompany.common.AccountDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author omar
 */
@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;
   

    public List<AccountDto> findAll() {
        log.debug("Request to get all Account");
        return this.accountRepository.findAll()
                .stream()
                .map(AccountService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AccountDto findById(Long id) {
        log.debug("Request to get Account : {}", id);
        return this.accountRepository.findById(id).map(AccountService::mapToDto).orElse(null);
    }

    public AccountDto create(AccountDto accountDto) {
        log.debug("Request to create Account : {}", accountDto);

        return mapToDto(this.accountRepository.save(
                new Account(TypeOfAccount.CURRENT, 0)));
    }

    public void delete(Long id) {
        log.debug("Request to delete Account : {}", id);
        this.accountRepository.deleteById(id);
    }

    public static AccountDto mapToDto(Account account) {
        if (account != null) {
            return new AccountDto(account.getId(), account.getTypeOfAccount().toString(), account.getAmount());
 
        }
        return null;
    }
}