package pl.web.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.web.service.model.Customer;
import pl.web.service.model.CustomerDto;
import pl.web.service.service.CustomerService;

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
        customer.setPassword(customerService.generatePassword());
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

    @GetMapping("/customer/{firstName}/{lastName}")
    @ResponseBody
    public Object getAllCustomersByName(@PathVariable String firstName, @PathVariable String lastName) {
        List <Customer> customers = customerService.getCustomersByNames(firstName, lastName);
        try {
            return customers.size() > 1 ? customers : customers.get(0);
        } catch (Exception e) {
            return "No element";
        }
    }

    @GetMapping("/customer/login")
    public ResponseEntity login() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("customer/login")
    public ResponseEntity login(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.findLoggingUser(customerDto.getNumber(), customerDto.getPassword());
        if (customer != null) {
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.FORBIDDEN);
        }
    }
}
