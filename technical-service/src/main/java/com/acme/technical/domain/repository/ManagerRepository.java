package com.acme.technical.domain.repository;

import com.acme.technical.domain.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
