package com.example.lostpetfinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.lostpetfinder.model.LostPetReport;
import com.example.lostpetfinder.repository.LostPetReportRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LostPetReportService {

    private final LostPetReportRepository lostPetReportRepository;

    public LostPetReportService(LostPetReportRepository lostPetReportRepository) {
        this.lostPetReportRepository = lostPetReportRepository;
    }

    public LostPetReport createLostPetReport(LostPetReport report) {
        return lostPetReportRepository.save(report);
    }

    public List<LostPetReport> getAllLostPetReports() {
        return lostPetReportRepository.findAll();
    }

    public List<LostPetReport> searchLostPetReportsByLocation(String location) {
        return lostPetReportRepository.findByLastSeenLocationContainingIgnoreCase(location);
    }

    public Optional<LostPetReport> getLostPetReportById(Long id) {
        return lostPetReportRepository.findById(id);
    }

    public LostPetReport resolveLostPetReport(Long id) {
        LostPetReport report = lostPetReportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lost pet report not found: " + id));
        report.setStatus("RESOLVED");
        return lostPetReportRepository.save(report);
    }

    public void deleteLostPetReport(Long id) {
        lostPetReportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lost pet report not found: " + id));
        lostPetReportRepository.deleteById(id);
    }
}
