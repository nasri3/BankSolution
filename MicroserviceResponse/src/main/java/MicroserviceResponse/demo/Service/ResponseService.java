/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceResponse.demo.Service;

import MicroserviceResponse.demo.Repository.ResponseRepository;
import MicroserviceResponse.demo.Entity.Loan;
import MicroserviceResponse.demo.Entity.Response;
import com.mycompany.common.ClientDto;
import com.mycompany.common.DemandDto;
import com.mycompany.common.LoanDto;
import com.mycompany.common.ResponseDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author nasri
 */
@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final RestTemplate restTemplate;
    private final LoanService loanService;

    public void delete(Long id) {
        Response response = this.responseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find response with id " + id));
        this.responseRepository.delete(response);
    }

    public void create(Response response) {
        log.debug("Request to create Response : {}", response);
        this.responseRepository.save(response);

    }

    public Response findById(Long id) {
        log.debug("Request to get Response : {}", id);
        return this.responseRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find response with id " + id));

    }

    public ResponseDto getResponse(long responseId) {
        return mapToDto(findById(responseId));
    }

    private boolean validateClientStatus(ClientDto client) {
        // validate personal situation
        //professional situation (employee, fixed-term or permanent contract, independent, precarious job ...)
        //your relationship with your bank

        return (client.getAge() < 65 && (client.getAverageOfGainPerMonth() != 0));

    }

    private boolean validateLoan(DemandDto demand, ClientDto clientDto) {
        //maximum reimbursemen 
        //duration of your loan (the longer this duration is important and the lower the rates),

        return (clientDto.getAverageOfGainPerMonth() * 75 > demand.getSumToLoan());

    }

    public ResponseDto studyDemand(DemandDto demand) {
        Response response = new Response();
        ClientDto clientDto = getClientDto(demand.getClientId()).get();
        response.setResult(validateClientStatus(clientDto) && validateLoan(demand, clientDto));
        if (response.isResult()) {
            Loan loan = new Loan(demand.getSumToLoan(), (int) ((int) demand.getSumToLoan() * 1.1 / (clientDto.getAverageOfGainPerMonth() * 0.30)),
                    clientDto.getAverageOfGainPerMonth() * 0.30,
                    0.10);
            this.loanService.create(loan);
            response.setLoan(loan);
        }
        create(response);
        return mapToDto(response);
    }

    @HystrixCommand(fallbackMethod = "getDefaultClientDto")
    private Optional<ClientDto> getClientDto(Long clientId) {
        RestTemplate restTemplate1 = new RestTemplate();
        ResponseEntity<ClientDto> resp = restTemplate1.getForEntity(
                "http://localhost:2222/clients/{id}",
                ClientDto.class,
                clientId
        );

        if (resp.getStatusCode() == HttpStatus.OK) {
            return Optional.ofNullable(resp.getBody());
        } else {
            log.error("Unable to get product with ID: " + clientId
                    + ", StatusCode: " + resp.getStatusCode());
            return Optional.empty();
        }

    }

    Optional<ClientDto> getDefaultClientDto() {
        log.info("Returning default ClientDto");
        ClientDto clientDto = new ClientDto(Long.MIN_VALUE, "FirstName", "LastName", LocalDateTime.MIN, 0, "job", 0, "email", 0, 0, null);
        return Optional.ofNullable(clientDto);
    }

    private ResponseDto mapToDto(Response response) {
        if (response.isResult()) {
            return new ResponseDto(response.getId(), response.isResult(),
                    new LoanDto(response.getLoan().getId(),
                            response.getLoan().getGivenSum(),
                            response.getLoan().getNbrMonths(),
                            response.getLoan().getInterestRate(),
                            response.getLoan().getSumPerMonth()));
        } else {
            return new ResponseDto(response.getId(), response.isResult(), null);
        }
    }

}
