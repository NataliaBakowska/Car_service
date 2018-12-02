package pl.web.service.service;

import pl.web.service.model.Repair;
import pl.web.service.repository.RepairRepository;

import java.util.Optional;

public class RepairService {

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
}
