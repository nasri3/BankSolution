/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceResponse.demo.Repository;

import MicroserviceResponse.demo.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nasri
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    
}
