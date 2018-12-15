package pl.web.service.service;

import org.apache.commons.lang3.RandomStringUtils;
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

    public Customer findLoggingUser(Long telephoneNumber, String password) {
        return customerRepository.findCustomerByTelephoneNumberAndPassword(telephoneNumber, password);
    }

    public String generatePassword() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public List<Customer> getCustomersByNames(String firstName, String lastName) {
        return customerRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }


}
