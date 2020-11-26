package pe.edu.upc.technicalservice.domain.repository;

import pe.edu.upc.technicalservice.domain.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
    public Optional<Engineer> findByEmail(String email);
}
