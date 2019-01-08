package pl.web.service.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

    /**
     * Save car assigning it to a given customer id
     * @param model
     * @param customerId
     * @return
     */
    @GetMapping("car/save/{customerId}")
    private ResponseEntity saveCar(Model model, @PathVariable Long customerId) {
        model.addAttribute("id",customerId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/car/save/{customerId}")
    public ResponseEntity saveCar(@RequestBody Car car, @PathVariable Long customerId) {
        car.setCustomer(customerRepository.findById(customerId).get());
        carRepository.save(car);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Get car with given id
     * @param id
     * @return
     */
    @GetMapping("/car/{id}")
    @ResponseBody
    public Car getCar(@PathVariable Long id) {
        return carRepository.findById(id).get();
    }

    /**
     * Get all cars
     * @return
     */
    @GetMapping("/car/all")
    @ResponseBody
    public List<Car> getllCars() {
        return carRepository.findAll();
    }

    /**
     * Get all cars linked to given customer id
     * @param customerId
     * @return
     */
    @GetMapping("/car/all/{customerId}")
    @ResponseBody
    public List<Car> getAllCarsForUser(@PathVariable Long customerId) {
        return carRepository.findAllByCustomerId(customerId);
    }

}
