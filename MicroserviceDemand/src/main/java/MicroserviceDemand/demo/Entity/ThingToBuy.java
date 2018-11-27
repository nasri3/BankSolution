/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceDemand.demo.Entity ;

import java.util.Objects;
import java.util.logging.Logger;
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
 * @author omar
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class ThingToBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    
    String category ;
    
    String description ;
    @NotNull
    @Column( precision =10)        
    double estimatedValue ;

    public ThingToBuy() {
        //some code ;
    }

    public ThingToBuy(String category, String description, double estimatedValue) {
        this.category = category;
        this.description = description;
        this.estimatedValue = estimatedValue;
    }

    
    
    
}
