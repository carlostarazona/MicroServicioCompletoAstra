package pe.edu.upc.documentationservice.service;

import pe.edu.upc.documentationservice.entity.FinalReport;

import java.util.List;
import java.util.Optional;

public interface FinalReportService {

    public List<FinalReport> findFinalReportAll();

    public FinalReport createFinalReport(FinalReport finalReport);
    public FinalReport updateFinalReport(FinalReport finalReport);
    public void deleteFinalReport(Long id);

    public Optional<FinalReport> getFinalReport(Long id);
}
