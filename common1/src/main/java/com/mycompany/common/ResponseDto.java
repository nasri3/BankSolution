package com.mycompany.common;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nasri
 */
@Data
@AllArgsConstructor
public class ResponseDto implements Serializable{
      private Long id;
    private boolean result;
    private LoanDto loan;

    
}
