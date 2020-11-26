package pe.edu.upc.technicalservice.controller;

import pe.edu.upc.technicalservice.domain.model.Engineer;
import pe.edu.upc.technicalservice.domain.service.EngineerService;
import pe.edu.upc.technicalservice.resource.EngineerResource;
import pe.edu.upc.technicalservice.resource.SaveEngineerResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class EngineersController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EngineerService engineerService;


    @GetMapping("/engineers")
    public ResponseEntity<List<EngineerResource>> getAllEngineers() {
        List<Engineer> engineersPage = engineerService.getAllEngineers();
        List<EngineerResource> resources = engineersPage
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }


    @GetMapping("/engineers/{engineerId}")
    public ResponseEntity<EngineerResource> getEngineerById(@PathVariable Long engineerId) {
        Engineer engineer = engineerService.getEngineerById(engineerId);
        EngineerResource resource = convertToResource(engineer);
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/engineers")
    public ResponseEntity<EngineerResource> createEngineer(@Valid @RequestBody SaveEngineerResource resource) {
        Engineer engineer = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(engineerService.createEngineer(engineer)));
    }

    @PutMapping("/engineers/{engineerId}")
    public ResponseEntity<EngineerResource> updateEngineer(@PathVariable Long engineerId, @RequestBody SaveEngineerResource resource) {
        Engineer engineer = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(engineerService.updateEngineer(engineerId, engineer)));
    }

    @DeleteMapping("/engineers/{engineerId}")
    public ResponseEntity<?> deleteEngineer(@PathVariable Long engineerId) {
        return engineerService.deleteEngineer(engineerId);
    }

    private Engineer convertToEntity(SaveEngineerResource resource) {
        return mapper.map(resource, Engineer.class);
    }

    private EngineerResource convertToResource(Engineer entity) {
        return mapper.map(entity, EngineerResource.class);
    }

}
