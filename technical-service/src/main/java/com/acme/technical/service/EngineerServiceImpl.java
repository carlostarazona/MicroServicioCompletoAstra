package com.acme.technical.service;

import com.acme.technical.domain.model.Engineer;
import com.acme.technical.domain.repository.EngineerRepository;
import com.acme.technical.domain.service.EngineerService;
import com.acme.technical.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerServiceImpl implements EngineerService {

    @Autowired
    private EngineerRepository engineerRepository;

    @Override
    public List<Engineer> getAllEngineers() {
        return engineerRepository.findAll();
    }

    @Override
    public Engineer getEngineerById(Long engineerId) {
        return engineerRepository.findById(engineerId)
                .orElseThrow(() ->
        new ResourceNotFoundException("Engineer", "Id", engineerId));
    }

    @Override
    public Engineer createEngineer(Engineer engineer) {
        return engineerRepository.save(engineer);
    }

    @Override
    public Engineer updateEngineer(Long engineerId, Engineer engineerRequest) {
        Engineer engineer = engineerRepository.findById(engineerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Engineer", "Id", engineerId));
        engineer.setIncidentAmount(engineerRequest.getIndicentAmount());
        engineer.setAvailability(engineerRequest.getAvailability());
        engineer.setWorkStatus(engineerRequest.getWorkStatus());
        return engineerRepository.save(engineer);

    }

    @Override
    public ResponseEntity<?> deleteEngineer(Long engineerId) {
        Engineer engineer = engineerRepository.findById(engineerId)
                .orElseThrow(()-> new ResourceNotFoundException("Engineer", "Id", engineerId));
        engineerRepository.delete(engineer);
        return ResponseEntity.ok().build();
    }

    @Override
    public Engineer getEngineerByEmail(String email) {
        return engineerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Engineer", "Email", email));

    }
}
