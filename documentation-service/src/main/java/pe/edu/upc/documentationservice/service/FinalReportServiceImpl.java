package pe.edu.upc.documentationservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.documentationservice.repository.FinalReportRepository;
import pe.edu.upc.documentationservice.entity.FinalReport;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class FinalReportServiceImpl implements FinalReportService {

    @Autowired
    FinalReportRepository finalReportRepository;


    @Override
    public List<FinalReport> findFinalReportAll() {
        return finalReportRepository.findAll();
    }

    @Override
    public FinalReport createFinalReport(FinalReport finalReport) {
       return  finalReportRepository.save(finalReport);
    }

    @Override
    public FinalReport updateFinalReport(FinalReport finalReport) {
        return  finalReportRepository.save(finalReport);
    }

    @Override
    public void deleteFinalReport(Long id) {
        finalReportRepository.deleteById(id);
    }


    @Override
    public Optional<FinalReport> getFinalReport(Long id) {
        return finalReportRepository.findById(id);
    }
}
