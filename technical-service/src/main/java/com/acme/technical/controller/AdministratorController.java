package com.acme.technical.controller;

import com.acme.technical.domain.model.Administrator;
import com.acme.technical.domain.service.AdministratorService;
import com.acme.technical.resource.AdministratorResource;
import com.acme.technical.resource.SaveAdministratorResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get Administrators", description = "Get All Administrators by Pages", tags = {"Administrators"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Administrators returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/administrators")
    public ResponseEntity<List<AdministratorResource>> getAllAdministrators() {
        List<Administrator> administratorsPage = administratorService.getAllAdministrators();
        List<AdministratorResource> resources = administratorsPage
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get Administrator", description = "Get an Administrator by Id", tags = {"Administrators"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrator returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/administrators/{administratorId}")
    public ResponseEntity<AdministratorResource> getAdministratorById(@PathVariable Long administratorId) {
        Administrator administrator = administratorService.getAdministratorById(administratorId);
        AdministratorResource resource = convertToResource(administrator);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Create Administrator", description = "Create a new Administrator", tags = {"Administrators"})
    @PostMapping("/administrators")
    public ResponseEntity<AdministratorResource> createAdministrator(@Valid @RequestBody SaveAdministratorResource resource) {
        Administrator administrator = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(administratorService.createAdministrator(administrator)));
    }

    @Operation(summary = "Update Administrator", description = "Update Administrator for given Id", tags = {"Administrators"})
    @PutMapping("/administrators/{administratorId}")
    public ResponseEntity<AdministratorResource> updateAdministrator(@PathVariable Long administratorId, @RequestBody SaveAdministratorResource resource) {
        Administrator administrator = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(administratorService.updateAdministrator(administratorId, administrator)));
    }

    @Operation(summary = "Delete Administrator", description = "Delete Administrators with given Id", tags = {"Administrators"})
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
