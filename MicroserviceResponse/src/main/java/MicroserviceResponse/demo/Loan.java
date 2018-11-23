/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceResponse.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author nasri
 */
@Entity
public class Loan {
     @Id
    @GeneratedValue
    private Long id;
    private double givenSum;
    private int nbrMonths;
    private double sumPerMonth;
    private double  interestRate;

    public Loan(Long id, double givenSum, int nbrMonths, double sumPerMonth, double interestRate) {
        this.id = id;
        this.givenSum = givenSum;
        this.nbrMonths = nbrMonths;
        this.sumPerMonth = sumPerMonth;
        this.interestRate = interestRate;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the givenSum
     */
    public double getGivenSum() {
        return givenSum;
    }

    /**
     * @param givenSum the givenSum to set
     */
    public void setGivenSum(double givenSum) {
        this.givenSum = givenSum;
    }

    /**
     * @return the nbrMonths
     */
    public int getNbrMonths() {
        return nbrMonths;
    }

    /**
     * @param nbrMonths the nbrMonths to set
     */
    public void setNbrMonths(int nbrMonths) {
        this.nbrMonths = nbrMonths;
    }

    /**
     * @return the sumPerMonth
     */
    public double getSumPerMonth() {
        return sumPerMonth;
    }

    /**
     * @param sumPerMonth the sumPerMonth to set
     */
    public void setSumPerMonth(double sumPerMonth) {
        this.sumPerMonth = sumPerMonth;
    }

    /**
     * @return the interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
   
    
    
    
}
