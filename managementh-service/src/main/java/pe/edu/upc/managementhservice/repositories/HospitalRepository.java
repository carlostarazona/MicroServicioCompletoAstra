package pe.edu.upc.managementhservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.managementhservice.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
