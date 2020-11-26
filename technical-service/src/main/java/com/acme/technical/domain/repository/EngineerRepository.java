package com.acme.technical.domain.repository;

import com.acme.technical.domain.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
    public Optional<Engineer> findByEmail(String email);
}
