package com.acme.technical.service;

import com.acme.technical.domain.model.Manager;
import com.acme.technical.domain.repository.ManagerRepository;
import com.acme.technical.domain.service.ManagerService;
import com.acme.technical.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManagerById(Long managerId) {
        return managerRepository.findById(managerId)
                .orElseThrow(() ->
        new ResourceNotFoundException("Manager", "Id", managerId));
    }

    @Override
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(Long managerId, Manager managerRequest) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Manager", "Id", managerId));
        manager.setRequestedtAmount(managerRequest.getRequestedtAmount());
        return managerRepository.save(manager);

    }

    @Override
    public ResponseEntity<?> deleteManager(Long managerId) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(()-> new ResourceNotFoundException("Manager", "Id", managerId));
        managerRepository.delete(manager);
        return ResponseEntity.ok().build();
    }

}
