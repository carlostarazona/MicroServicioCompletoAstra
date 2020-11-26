package pe.edu.upc.technicalservice.domain.repository;

import pe.edu.upc.technicalservice.domain.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    //public Optional<Engineer> findByTitle(String title);
}
