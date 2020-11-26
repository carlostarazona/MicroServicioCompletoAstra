package com.acme.technical.controller;

import com.acme.technical.domain.model.Plan;
import com.acme.technical.domain.service.PlanService;
import com.acme.technical.resource.PlanResource;
import com.acme.technical.resource.SavePlanResource;
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
public class PlansController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlanService planService;

    @Operation(summary = "Get Plans", description = "Get All Plans by Pages", tags = {"Plans"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Plans returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/plans")
    public ResponseEntity<List<PlanResource>> getAllPlans() {
        List<Plan> plansPage = planService.getAllPlans();
        List<PlanResource> resources = plansPage
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get Plan", description = "Get a Plan by Id", tags = {"Plans"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plan returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/plans/{planId}")
    public ResponseEntity<PlanResource> getPlanById(@PathVariable Long planId) {
        Plan plan = planService.getPlanById(planId);
        PlanResource resource = convertToResource(plan);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Create Plan", description = "Create a new Plan", tags = {"Plans"})
    @PostMapping("/plans")
    public ResponseEntity<PlanResource> createPlan(@Valid @RequestBody SavePlanResource resource) {
        Plan plan = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(planService.createPlan(plan)));
    }

    @Operation(summary = "Update Plan", description = "Update Plan for given Id", tags = {"Plans"})
    @PutMapping("/plans/{planId}")
    public ResponseEntity<PlanResource> updatePlan(@PathVariable Long planId, @RequestBody SavePlanResource resource) {
        Plan plan = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(planService.updatePlan(planId, plan)));
    }

    @Operation(summary = "Delete Plan", description = "Delete Plans with given Id", tags = {"Plans"})
    @DeleteMapping("/plans/{planId}")
    public ResponseEntity<?> deletePlan(@PathVariable Long planId) {
        return planService.deletePlan(planId);
    }

    private Plan convertToEntity(SavePlanResource resource) {
        return mapper.map(resource, Plan.class);
    }

    private PlanResource convertToResource(Plan entity) {
        return mapper.map(entity, PlanResource.class);
    }

}
