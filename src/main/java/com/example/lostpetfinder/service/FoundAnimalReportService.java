package com.example.lostpetfinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.lostpetfinder.model.FoundAnimalReport;
import com.example.lostpetfinder.repository.FoundAnimalReportRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FoundAnimalReportService {

    private final FoundAnimalReportRepository foundAnimalReportRepository;

    public FoundAnimalReportService(FoundAnimalReportRepository foundAnimalReportRepository) {
        this.foundAnimalReportRepository = foundAnimalReportRepository;
    }

    public FoundAnimalReport createFoundAnimalReport(FoundAnimalReport report) {
        return foundAnimalReportRepository.save(report);
    }

    public List<FoundAnimalReport> getAllFoundAnimalReports() {
        return foundAnimalReportRepository.findAll();
    }

    public Optional<FoundAnimalReport> getFoundAnimalReportById(Long id) {
        return foundAnimalReportRepository.findById(id);
    }

    public FoundAnimalReport resolveFoundAnimalReport(Long id) {
        FoundAnimalReport report = foundAnimalReportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Found animal report not found: " + id));
        report.setStatus("RESOLVED");
        return foundAnimalReportRepository.save(report);
    }

    public void deleteFoundAnimalReport(Long id) {
        foundAnimalReportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Found animal report not found: " + id));
        foundAnimalReportRepository.deleteById(id);
    }
}
