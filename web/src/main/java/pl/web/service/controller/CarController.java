package pl.web.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.web.service.model.Car;
import pl.web.service.repository.CarRepository;
import pl.web.service.repository.CustomerRepository;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("car/save/{customerId}")
    private ResponseEntity saveCar() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/car/save/{customerId}")
    public ResponseEntity saveCar(@RequestBody Car car, @PathVariable Long customerId) {
        car.setCustomer(customerRepository.findById(customerId).get());
        carRepository.save(car);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/car/{id}")
    @ResponseBody
    public Car getCar(@PathVariable Long id) {
        return carRepository.findById(id).get();
    }

    @GetMapping("/car/all")
    @ResponseBody
    public List<Car> getllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/car/all/{userId}")
    @ResponseBody
    public List<Car> getAllCarsForUser(@PathVariable Long userId) {
        return carRepository.findAllByCustomerId(userId);
    }

}
