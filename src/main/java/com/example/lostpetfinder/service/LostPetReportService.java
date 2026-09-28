package com.example.lostpetfinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.lostpetfinder.model.LostPetReport;
import com.example.lostpetfinder.repository.LostPetReportRepository;

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

    public Optional<LostPetReport> getLostPetReportById(Long id) {
        return lostPetReportRepository.findById(id);
    }

    public void deleteLostPetReport(Long id) {
        lostPetReportRepository.deleteById(id);
    }
}
