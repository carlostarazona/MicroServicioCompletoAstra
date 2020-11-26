package pe.edu.upc.technicalservice.domain.repository;

import pe.edu.upc.technicalservice.domain.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
