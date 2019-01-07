package pl.web.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.web.service.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository <Car, Long> {
    List<Car> findAllByCustomerId(Long id);
}
