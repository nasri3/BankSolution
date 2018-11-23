/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceDemand.demo;

import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author omar
 */
@Entity
public class ThingToBuy {
    @Id
    @GeneratedValue
    Long id ;
    
    String category ;
    
    String description ;
    
    double estimatedValue ;

    public ThingToBuy() {
        //some code ;
    }

    public ThingToBuy(Long id, String category, String description, double estimatedValue) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.estimatedValue = estimatedValue;
    }

    public ThingToBuy(String description, double estimatedValue) {
        this.description = description;
        this.estimatedValue = estimatedValue;
    }
    
   

    @Override
    public String toString() {
        return "ThingTobBy{" + "id=" + id + ", category=" + category + ", description=" + description + ", estimatedValue=" + estimatedValue + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ThingToBuy other = (ThingToBuy) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getEstimatedValue() {
        return estimatedValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEstimatedValue(double estimatedValue) {
        this.estimatedValue = estimatedValue;
    }
    
    
    
    
    
    
    
    
    
}
