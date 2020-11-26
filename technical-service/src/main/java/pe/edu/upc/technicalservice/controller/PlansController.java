package pe.edu.upc.technicalservice.controller;

import pe.edu.upc.technicalservice.domain.model.Plan;
import pe.edu.upc.technicalservice.domain.service.PlanService;
import pe.edu.upc.technicalservice.resource.PlanResource;
import pe.edu.upc.technicalservice.resource.SavePlanResource;
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


    @GetMapping("/plans")
    public ResponseEntity<List<PlanResource>> getAllPlans() {
        List<Plan> plansPage = planService.getAllPlans();
        List<PlanResource> resources = plansPage
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }


    @GetMapping("/plans/{planId}")
    public ResponseEntity<PlanResource> getPlanById(@PathVariable Long planId) {
        Plan plan = planService.getPlanById(planId);
        PlanResource resource = convertToResource(plan);
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/plans")
    public ResponseEntity<PlanResource> createPlan(@Valid @RequestBody SavePlanResource resource) {
        Plan plan = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(planService.createPlan(plan)));
    }

    @PutMapping("/plans/{planId}")
    public ResponseEntity<PlanResource> updatePlan(@PathVariable Long planId, @RequestBody SavePlanResource resource) {
        Plan plan = convertToEntity(resource);
        return ResponseEntity.ok(convertToResource(planService.updatePlan(planId, plan)));
    }

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
