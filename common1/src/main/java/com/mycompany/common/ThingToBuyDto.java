/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.common;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author nasri
 */
@Data
@AllArgsConstructor
public class ThingToBuyDto implements Serializable {
    Long id ;
    String category ;
    String description ;
    double estimatedValue ;
    
}
