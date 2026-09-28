package com.example.lostpetfinder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lostpetfinder.model.LostPetReport;
import com.example.lostpetfinder.service.LostPetReportService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/lost-pets")
public class LostPetReportController {

    private final LostPetReportService lostPetReportService;

    public LostPetReportController(LostPetReportService lostPetReportService) {
        this.lostPetReportService = lostPetReportService;
    }

    @PostMapping
    public LostPetReport createLostPetReport(@Valid @RequestBody LostPetReport report) {
        return lostPetReportService.createLostPetReport(report);
    }

    @GetMapping
    public List<LostPetReport> getAllLostPetReports() {
        return lostPetReportService.getAllLostPetReports();
    }

    @GetMapping("/{id}")
    public Optional<LostPetReport> getLostPetReportById(@PathVariable Long id) {
        return lostPetReportService.getLostPetReportById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLostPetReport(@PathVariable Long id) {
        lostPetReportService.deleteLostPetReport(id);
    }
}
