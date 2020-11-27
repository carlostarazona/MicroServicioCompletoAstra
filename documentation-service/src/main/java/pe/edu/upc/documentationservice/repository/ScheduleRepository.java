package pe.edu.upc.documentationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.documentationservice.entity.Schedule;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
