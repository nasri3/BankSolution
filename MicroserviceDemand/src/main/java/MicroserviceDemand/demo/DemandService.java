/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceDemand.demo;

import java.util.List;
import java.util.Optional;
import static jdk.nashorn.internal.objects.NativeMath.log;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author omar
 */

@Service
public class DemandService {
    private final DemandRepository demandRepository;
 

    public DemandService(DemandRepository demandRepository) {
        this.demandRepository = demandRepository;
    }
    
    
    public void delete(Long id) {
       // log.debug("Request to delete Customer : {}", id);

        Demand  demand = this.demandRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));
        this.demandRepository.delete(demand);
    }
    
        public void create(Demand demand) {
       // log.debug("Request to create Customer : {}", customerDto);
        
                this.demandRepository.save(demand);
    
       }
        
        public void update(Demand demand){
            //this.demandRepository.
        }

        public List<Demand> findAll() {
       // log.debug("Request to get all Categories");
        return this.demandRepository.findAll();
               
    }
        
        public  Optional<Demand> findById(Long id){
            return this.demandRepository.findById(id);
        }
        
     public List<Demand> findAllUnprocessed(){
       List<Demand> unprocessed = findAll().stream()
               .filter(demand -> demand.getIdResponse()==null)
               .collect(Collectors.toList());
       return unprocessed;
     }
     
     public boolean  IsItProcessed(Long id){
         if(findById(id).isPresent())
         {
           if (findById(id).get().getIdResponse()!=null)
              return true;
           
         }
         return false;
     }
     
  
   
    
}
