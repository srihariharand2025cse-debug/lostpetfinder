package com.example.lostpetfinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.lostpetfinder.model.FoundAnimalReport;
import com.example.lostpetfinder.repository.FoundAnimalReportRepository;

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

    public void deleteFoundAnimalReport(Long id) {
        foundAnimalReportRepository.deleteById(id);
    }
}
