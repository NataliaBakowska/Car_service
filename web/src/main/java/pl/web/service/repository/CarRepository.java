package pl.web.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.web.service.model.Car;

public interface CarRepository extends JpaRepository <Car, Long> {
}
