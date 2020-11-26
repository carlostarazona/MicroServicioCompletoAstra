package pe.edu.upc.technicalservice.service;

import pe.edu.upc.technicalservice.domain.model.Plan;
import pe.edu.upc.technicalservice.domain.repository.PlanRepository;
import pe.edu.upc.technicalservice.domain.service.PlanService;
import pe.edu.upc.technicalservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public Plan getPlanById(Long planId) {
        return planRepository.findById(planId)
                .orElseThrow(() ->
        new ResourceNotFoundException("Plan", "Id", planId));
    }

    @Override
    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan updatePlan(Long planId, Plan planRequest) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Plan", "Id", planId));
        plan.setPlanName(planRequest.getPlanName());
        plan.setEngineerCount(planRequest.getEngineerCount());
        return planRepository.save(plan);

    }

    @Override
    public ResponseEntity<?> deletePlan(Long planId) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(()-> new ResourceNotFoundException("Plan", "Id", planId));
        planRepository.delete(plan);
        return ResponseEntity.ok().build();
    }

//    @Override
//    public Plan getPlanByTitle(String title) {
//        return planRepository.findByTitle(title)
//                .orElseThrow(() -> new ResourceNotFoundException("Plan", "Title", title));
//    }
}
