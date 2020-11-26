package com.acme.technical.domain.repository;

import com.acme.technical.domain.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    //public Optional<Engineer> findByTitle(String title);
}
