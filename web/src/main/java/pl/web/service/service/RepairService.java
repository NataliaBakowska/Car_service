package pl.web.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.web.service.model.Repair;
import pl.web.service.repository.RepairRepository;

import java.util.Optional;

@Service
public class RepairService {

    @Autowired
    RepairRepository repairRepository;

    public void saveAction(Repair repair) {
        repairRepository.save(repair);
    }

    public Optional<Repair> getById(Long id) {
        return repairRepository.findById(id);
    }

    public void deleteRepair(Long id){
        repairRepository.deleteById(id);
    }

    public void updateRepair(Long id, Repair newRepair) {
        Repair repairToEdit = repairRepository.findById(id).get();
        repairToEdit = newRepair;
    }
}
