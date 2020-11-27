package pe.edu.upc.managementhservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.managementhservice.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
