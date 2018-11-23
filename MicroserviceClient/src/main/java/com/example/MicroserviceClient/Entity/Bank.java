/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MicroserviceClient.Entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author omar
 */
@Entity
public class Bank {
    @Id
    @GeneratedValue
    Long id ;
    
    String name ;
    
    @OneToMany
     List<Account> accounts;       
    
    double capital ;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public double getCapital() {
        return capital;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

  

    public void setCapital(double capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Bank{" + "id=" + id + ", name=" + name +  ", capital=" + capital + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Bank other = (Bank) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Bank() {
        
        this.name="my Bank";
    }

    public Bank(Long id, String name, List<Account> accounts, double capital) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
        this.capital = capital;
    }


    
    
    
            
            
}
