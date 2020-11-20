package pe.edu.upc.documentationservice.service;



import pe.edu.upc.documentationservice.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    public List<Schedule> findScheduleAll();

    public Schedule createSchedule(Schedule schedule);
    public Schedule updateSchedule(Schedule schedule);
    public void deleteSchedule(Long id);

    public Optional<Schedule> getSchedule(Long id);
}
