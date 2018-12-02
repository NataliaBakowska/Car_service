package pl.web.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.web.service.model.Repair;

public interface RepairRepository extends JpaRepository <Repair, Long> {
}
