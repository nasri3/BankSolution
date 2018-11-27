/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceDemand.demo.Entity ;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @NotNull
    double sumToLoan ;
    @NotNull
    Long idClient ;
    @OneToOne
    ThingToBuy thing ;
    Long idResponse;

    public Demand(double sumToLoan, long idClient, ThingToBuy thing, Long idResponse) {
        this.sumToLoan = sumToLoan;
        this.idClient = idClient;
        this.thing = thing;
        this.idResponse = idResponse;
    }
    

    public Demand() {
        //coooode nigga ..
    } 
 
}
