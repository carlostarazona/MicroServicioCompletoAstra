package pe.edu.upc.documentationservice.service;

import pe.edu.upc.documentationservice.entity.EngineerReport;

import java.util.List;
import java.util.Optional;

public interface EngineerReportService {

    public List<EngineerReport> findEngineerReportAll();

    public EngineerReport createEngineerReport(EngineerReport engineerReport);
    public EngineerReport updateEngineerReport(EngineerReport engineerReport);
    public void deleteEngineerReport(Long id);

    public Optional<EngineerReport> getEngineerReport(Long id);
}
