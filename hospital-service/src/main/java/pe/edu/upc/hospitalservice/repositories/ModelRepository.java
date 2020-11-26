package pe.edu.upc.hospitalservice.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.hospitalservice.entities.Model;


import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {

    Optional<Model> findByModelName(String nameModel);
}
