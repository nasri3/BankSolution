/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceDemand.demo.Repository;

import MicroserviceDemand.demo.Entity.ThingToBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author omar
 */
@Repository
public interface ThingToBuyRepository extends JpaRepository<ThingToBuy, Object> {
    
}
