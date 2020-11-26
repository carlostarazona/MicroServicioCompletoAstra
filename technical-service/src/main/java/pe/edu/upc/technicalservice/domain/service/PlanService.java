package pe.edu.upc.technicalservice.domain.service;

import pe.edu.upc.technicalservice.domain.model.Plan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlanService {
    List<Plan> getAllPlans();
    Plan getPlanById(Long panId);
    Plan createPlan(Plan pan);
    Plan updatePlan(Long panId, Plan panRequest);
    ResponseEntity<?> deletePlan(Long panId);
}
