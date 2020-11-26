package pe.edu.upc.technicalservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get Engineers", description = "Get All Engineers by Pages", tags = {"Engineers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Engineers returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/engineers")
    public ResponseEntity<List<EngineerResource>> getAllEngineers() {
        List<Engineer> engineersPage = engineerService.getAllEngineers();
        List<EngineerResource> resources = engineersPage
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get Engineer", description = "Get an Engineer by Id", tags = {"Engineers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Engineer returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/engineers/{engineerId}")
    public ResponseEntity<EngineerResource> getEngineerById(@PathVariable Long engineerId) {
        Engineer engineer = engineerService.getEngineerById(engineerId);
        EngineerResource resource = convertToResource(engineer);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Create Engineer", description = "Create a new Engineer", tags = {"Engineers"})
    @PostMapping("/engineers")
    public ResponseEntity<EngineerResource> createEngineer(@Valid @RequestBody SaveEngineerResource resource) {
        Engineer engineer = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(engineerService.createEngineer(engineer)));
    }

    @Operation(summary = "Update Engineer", description = "Update Engineer for given Id", tags = {"Engineers"})
    @PutMapping("/engineers/{engineerId}")
    public ResponseEntity<EngineerResource> updateEngineer(@PathVariable Long engineerId, @RequestBody SaveEngineerResource resource) {
        Engineer engineer = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(engineerService.updateEngineer(engineerId, engineer)));
    }

    @Operation(summary = "Delete Engineer", description = "Delete Engineers with given Id", tags = {"Engineers"})
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
