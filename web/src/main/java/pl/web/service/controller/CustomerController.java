package pl.web.service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.org.apache.xpath.internal.operations.Mod;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.web.service.model.Customer;
import pl.web.service.model.CustomerDto;
import pl.web.service.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * Create a new customer
     * @return
     */
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

    /**
     * Get a customer by id
     * @param id
     * @return customer WITHOUT assigned cars
     */
    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getById(id).get();
    }

    /**
     * Get all customers
     * @return customer WITHOUT assigned cars
     */
    @GetMapping("/customer/all")
    @ResponseBody
    public List<Customer> getAllCustomers () {
        return customerService.getAll();
    }

    /**
     * Get all customers with given firstName and lastName
     * @param firstName
     * @param lastName
     * @return
     */
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

    /**
     * Login api for customers, requires telephone number and auto-generated password
     * @return
     */
    @GetMapping("/customer/login")
    public ResponseEntity login() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("customer/login")
    public Object login(@RequestBody CustomerDto customerDto) throws JsonProcessingException {
        Customer customer = customerService.findLoggingUser(customerDto.getNumber(), customerDto.getPassword());
        if (customer != null) {
            return new ResponseEntity<Object>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
