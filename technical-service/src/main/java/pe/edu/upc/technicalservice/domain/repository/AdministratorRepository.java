package pe.edu.upc.technicalservice.domain.repository;

import pe.edu.upc.technicalservice.domain.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    public Optional<Administrator> findByEmail(String email);
}
