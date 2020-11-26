package pe.edu.upc.technicalservice.domain.service;

import pe.edu.upc.technicalservice.domain.model.Manager;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ManagerService {
    List<Manager> getAllManagers();
    Manager getManagerById(Long managerId);
    Manager createManager(Manager manager);
    Manager updateManager(Long managerId, Manager managerRequest);
    ResponseEntity<?> deleteManager(Long managerId);
}
