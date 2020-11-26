package pe.edu.upc.technicalservice.domain.service;

import pe.edu.upc.technicalservice.domain.model.Engineer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EngineerService {
    List<Engineer> getAllEngineers();
    Engineer getEngineerById(Long engineerId);
    Engineer createEngineer(Engineer engineer);
    Engineer updateEngineer(Long engineerId, Engineer engineerRequest);
    ResponseEntity<?> deleteEngineer(Long engineerId);

    Engineer getEngineerByEmail(String email);
}
