/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroserviceDemand.demo.Service;

import MicroserviceDemand.demo.Entity.Demand;
import MicroserviceDemand.demo.Repository.DemandRepository;
import com.mycompany.common.ClientDto;
import com.mycompany.common.DemandDto;
import com.mycompany.common.ResponseDto;
import com.mycompany.common.ThingToBuyDto;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static jdk.nashorn.internal.objects.NativeMath.log;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author omar
 */
@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class DemandService {

    private final DemandRepository demandRepository;

    public void delete(Long id) {
        log.debug("Request to delete Demand : {}", id);
        Demand demand = this.demandRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));
        this.demandRepository.delete(demand);
    }

    public void create(Demand demand) {
        log.debug("Request to create Demand : {}", demand);
        this.demandRepository.save(demand);

    }

    public void update(Long idDemand, Long idResponse) {
        Demand demand = findById(idDemand);
        demand.setIdResponse(idResponse);
        this.demandRepository.save(demand);
        log.debug("Request to update Demand successed : {}");

    }

    public List<DemandDto> findAll() {
        log.debug("Request to get all Demands");
        return this.demandRepository.findAll()
                .stream()
                .map(DemandService::mapToDto)
                .collect(Collectors.toList());

    }

    public Demand findById(Long id) {
        return this.demandRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find response with id " + id));
    }

    public List<DemandDto> findByClient(Long clienId) {
        return findAll().stream()
                .filter(d -> d.getClientId() == clienId)
                .collect(Collectors.toList());
    }

    public List<DemandDto> findAllUnprocessed() {
        List<DemandDto> unprocessed = findAll().stream()
                .filter(demand -> Objects.equals(demand.getResponseId(), new Long(-1) ))
                .collect(Collectors.toList());
        return unprocessed;
    }

    public boolean isTraited(long demandId) {
        return !Objects.equals(findById(demandId).getIdResponse(), new Long(-1));
    }

    public static DemandDto mapToDto(Demand demand) {
        return new DemandDto(demand.getId(), demand.getSumToLoan(), demand.getIdClient(), new ThingToBuyDto(demand.getThing().getId(),
                 demand.getThing().getCategory(), demand.getThing().getDescription(), demand.getThing().getEstimatedValue()),
                 demand.getIdResponse());

    }

}
