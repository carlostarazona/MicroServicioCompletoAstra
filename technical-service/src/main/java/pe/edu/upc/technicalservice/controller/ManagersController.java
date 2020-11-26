package pe.edu.upc.technicalservice.controller;

import pe.edu.upc.technicalservice.domain.model.Manager;
import pe.edu.upc.technicalservice.domain.service.ManagerService;
import pe.edu.upc.technicalservice.resource.ManagerResource;
import pe.edu.upc.technicalservice.resource.SaveManagerResource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class ManagersController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ManagerService managerService;

    @GetMapping("/managers")
    public ResponseEntity<List<ManagerResource>> getAllManagers() {
        List<Manager> managersPage = managerService.getAllManagers();
        List<ManagerResource> resources = managersPage
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }

    @GetMapping("/managers/{managerId}")
    public ResponseEntity<ManagerResource> getManagerById(@PathVariable Long managerId) {
        Manager manager = managerService.getManagerById(managerId);
        ManagerResource resource = convertToResource(manager);
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/managers")
    public ResponseEntity<ManagerResource> createManager(@Valid @RequestBody SaveManagerResource resource) {
        Manager manager = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(managerService.createManager(manager)));
    }

    @PutMapping("/managers/{managerId}")
    public ResponseEntity<ManagerResource> updateManager(@PathVariable Long managerId, @RequestBody SaveManagerResource resource) {
        Manager manager = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(managerService.updateManager(managerId, manager)));
    }

    @DeleteMapping("/managers/{managerId}")
    public ResponseEntity<?> deleteManager(@PathVariable Long managerId) {
        return managerService.deleteManager(managerId);
    }

    private Manager convertToEntity(SaveManagerResource resource) {
        return mapper.map(resource, Manager.class);
    }

    private ManagerResource convertToResource(Manager entity) {
        return mapper.map(entity, ManagerResource.class);
    }

}
