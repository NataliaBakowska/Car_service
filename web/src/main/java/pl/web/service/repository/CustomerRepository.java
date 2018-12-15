package pl.web.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.web.service.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

    Customer findCustomerByTelephoneNumberAndPassword(Long telephoneNumber, String password);

    List<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);

}
