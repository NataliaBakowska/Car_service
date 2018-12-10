package pl.web.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.web.service.model.Customer;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

}
