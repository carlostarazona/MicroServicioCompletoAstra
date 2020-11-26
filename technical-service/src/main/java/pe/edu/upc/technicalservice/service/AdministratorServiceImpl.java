package pe.edu.upc.technicalservice.service;

import pe.edu.upc.technicalservice.domain.model.Administrator;
import pe.edu.upc.technicalservice.domain.repository.AdministratorRepository;
import pe.edu.upc.technicalservice.domain.service.AdministratorService;
import pe.edu.upc.technicalservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator getAdministratorById(Long administratorId) {
        return administratorRepository.findById(administratorId)
                .orElseThrow(() ->
        new ResourceNotFoundException("Administrator", "Id", administratorId));
    }

    @Override
    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator updateAdministrator(Long administratorId, Administrator administratorRequest) {
        Administrator administrator = administratorRepository.findById(administratorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Administrator", "Id", administratorId));
        administrator.setIncidentAmount(administratorRequest.getIncidentAmount());
        administrator.setPlan(administratorRequest.getPlan());
        return administratorRepository.save(administrator);

    }

    @Override
    public ResponseEntity<?> deleteAdministrator(Long administratorId) {
        Administrator administrator = administratorRepository.findById(administratorId)
                .orElseThrow(()-> new ResourceNotFoundException("Administrator", "Id", administratorId));
        administratorRepository.delete(administrator);
        return ResponseEntity.ok().build();
    }

    @Override
    public Administrator getAdministratorByEmail(String email) {
        return administratorRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Administrator", "Email", email));

    }
}
