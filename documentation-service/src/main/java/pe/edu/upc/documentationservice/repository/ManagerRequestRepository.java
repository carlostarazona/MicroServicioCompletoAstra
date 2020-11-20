package pe.edu.upc.documentationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.documentationservice.entity.ManagerRequest;

@Repository
public interface ManagerRequestRepository extends JpaRepository<ManagerRequest, Long> {
}
