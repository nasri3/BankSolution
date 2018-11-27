/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceResponse.demo.Service;

import MicroserviceResponse.demo.Entity.Loan;
import MicroserviceResponse.demo.Entity.Response;
import MicroserviceResponse.demo.Repository.LoanRepository;
import MicroserviceResponse.demo.Repository.ResponseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author nasri
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public void delete(Long id) {
        Loan loan = this.loanRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Loan with id " + id));
        this.loanRepository.delete(loan);
    }

    public void create(Loan loan) {
        log.debug("Request to create Loan : {}", loan);
        this.loanRepository.save(loan);

    }

    public Loan findById(Long id) {
        log.debug("Request to get Loan : {}", id);
        return this.loanRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find loan with id " + id));

    }

}
