package pe.edu.upc.servicemanagement.repositories;

import pe.edu.upc.servicemanagement.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
