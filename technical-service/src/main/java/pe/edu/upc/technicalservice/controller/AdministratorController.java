package pe.edu.upc.technicalservice.controller;

import pe.edu.upc.technicalservice.domain.model.Administrator;
import pe.edu.upc.technicalservice.domain.service.AdministratorService;
import pe.edu.upc.technicalservice.resource.AdministratorResource;
import pe.edu.upc.technicalservice.resource.SaveAdministratorResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class AdministratorController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AdministratorService administratorService;


    @GetMapping("/administrators")
    public ResponseEntity<List<AdministratorResource>> getAllAdministrators() {
        List<Administrator> administratorsPage = administratorService.getAllAdministrators();
        List<AdministratorResource> resources = administratorsPage
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }


    @GetMapping("/administrators/{administratorId}")
    public ResponseEntity<AdministratorResource> getAdministratorById(@PathVariable Long administratorId) {
        Administrator administrator = administratorService.getAdministratorById(administratorId);
        AdministratorResource resource = convertToResource(administrator);
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/administrators")
    public ResponseEntity<AdministratorResource> createAdministrator(@Valid @RequestBody SaveAdministratorResource resource) {
        Administrator administrator = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(administratorService.createAdministrator(administrator)));
    }

    @PutMapping("/administrators/{administratorId}")
    public ResponseEntity<AdministratorResource> updateAdministrator(@PathVariable Long administratorId, @RequestBody SaveAdministratorResource resource) {
        Administrator administrator = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(administratorService.updateAdministrator(administratorId, administrator)));
    }

    @DeleteMapping("/administrators/{administratorId}")
    public ResponseEntity<?> deleteAdministrator(@PathVariable Long administratorId) {
        return administratorService.deleteAdministrator(administratorId);
    }

    private Administrator convertToEntity(SaveAdministratorResource resource) {
        return mapper.map(resource, Administrator.class);
    }

    private AdministratorResource convertToResource(Administrator entity) {
        return mapper.map(entity, AdministratorResource.class);
    }

}
