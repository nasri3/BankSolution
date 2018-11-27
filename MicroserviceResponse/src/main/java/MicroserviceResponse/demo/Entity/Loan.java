/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceResponse.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author nasri
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(precision=10)
    private double givenSum;
    @NotNull
    private int nbrMonths;
    @NotNull
    private double sumPerMonth;
    @NotNull
    private double  interestRate;

    public Loan(double givenSum, int nbrMonths, double sumPerMonth, double interestRate) {
        
        this.givenSum = givenSum;
        this.nbrMonths = nbrMonths;
        this.sumPerMonth = sumPerMonth;
        this.interestRate = interestRate;
    }

    public Loan() {
        //for JPA
    }

  
    
    
}
