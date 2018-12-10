package pl.web.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.web.service.model.Customer;
import pl.web.service.service.CustomerService;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/save")
    public ResponseEntity saveCustomer() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/customer/save")
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getById(id).get();
    }

    @GetMapping("/customer/all")
    @ResponseBody
    public List<Customer> getAllCustomers () {
        return customerService.getAll();
    }
}
