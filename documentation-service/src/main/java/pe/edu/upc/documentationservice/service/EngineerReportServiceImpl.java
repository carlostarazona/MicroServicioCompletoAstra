package pe.edu.upc.documentationservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.documentationservice.entity.EngineerReport;
import pe.edu.upc.documentationservice.repository.EngineerReportRepository;


import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class EngineerReportServiceImpl implements EngineerReportService {

    @Autowired
    EngineerReportRepository engineerReportRepository;


    @Override
    public List<EngineerReport> findEngineerReportAll() {
        return engineerReportRepository.findAll();
    }

    @Override
    public EngineerReport createEngineerReport(EngineerReport engineerReport) {
        return engineerReportRepository.save(engineerReport);
    }

    @Override
    public EngineerReport updateEngineerReport(EngineerReport engineerReport) {
        return engineerReportRepository.save(engineerReport);
    }

    @Override
    public void deleteEngineerReport(Long id) {
        engineerReportRepository.deleteById(id);
    }



    @Override
    public Optional<EngineerReport> getEngineerReport(Long id) {
        return engineerReportRepository.findById(id);
    }
}
