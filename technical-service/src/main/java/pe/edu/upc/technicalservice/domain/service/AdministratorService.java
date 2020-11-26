package pe.edu.upc.technicalservice.domain.service;

import pe.edu.upc.technicalservice.domain.model.Administrator;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdministratorService {
    List<Administrator> getAllAdministrators();
    Administrator getAdministratorById(Long administratorId);
    Administrator createAdministrator(Administrator administrator);
    Administrator updateAdministrator(Long administratorId, Administrator administratorRequest);
    ResponseEntity<?> deleteAdministrator(Long administratorId);
    Administrator getAdministratorByEmail(String email);
}
