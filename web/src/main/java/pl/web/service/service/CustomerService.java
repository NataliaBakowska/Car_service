package pl.web.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.web.service.model.Car;
import pl.web.service.model.Customer;
import pl.web.service.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Long id, Customer newCustomer) {
        Customer customerToEdit = customerRepository.findById(id).get();
        customerToEdit = newCustomer;
    }


}
