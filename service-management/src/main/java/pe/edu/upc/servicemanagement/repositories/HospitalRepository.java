package pe.edu.upc.servicemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.servicemanagement.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
