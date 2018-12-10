package pl.web.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.web.service.model.Repair;

import java.util.List;

public interface RepairRepository extends JpaRepository <Repair, Long> {

    List<Repair> findAllByCarId(Long id);
}
