package pl.web.service.service;

import pl.web.service.model.Customer;
import pl.web.service.repository.CustomerRepository;

import java.util.Optional;

public class CustomerService {

    CustomerRepository customerRepository;

    public void saveAction(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
