package pl.web.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.web.service.model.Repair;
import pl.web.service.repository.CarRepository;
import pl.web.service.repository.RepairRepository;
import java.util.List;

@RestController
public class RepairController {

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private CarRepository carRepository;


    @GetMapping("/repair/save/{carId}")
    private ResponseEntity saveRepair() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/repair/save/{carId}")
    public ResponseEntity saveRepair (@RequestBody Repair repair, @PathVariable Long carId) {
        repair.setCar(carRepository.findById(carId).get());
        repairRepository.save(repair);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/repair/{id}")
    @ResponseBody
    public Repair getRepair (@PathVariable Long id) {
        return repairRepository.findById(id).get();
    }

    @GetMapping("/repair/all")
    @ResponseBody
    public List<Repair> getAllRepairs() {
        return repairRepository.findAll();
    }

    @GetMapping("/repair/all/{carId}")
    @ResponseBody
    public List<Repair> getAllRepairsForCar(@PathVariable Long carId) {
        return repairRepository.findAllByCarId(carId);
    }
}
