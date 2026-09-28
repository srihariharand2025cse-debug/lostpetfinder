package com.example.lostpetfinder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lostpetfinder.model.FoundAnimalReport;
import com.example.lostpetfinder.service.FoundAnimalReportService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/found-animals")
public class FoundAnimalReportController {

    private final FoundAnimalReportService foundAnimalReportService;

    public FoundAnimalReportController(FoundAnimalReportService foundAnimalReportService) {
        this.foundAnimalReportService = foundAnimalReportService;
    }

    @PostMapping
    public FoundAnimalReport createFoundAnimalReport(@Valid @RequestBody FoundAnimalReport report) {
        return foundAnimalReportService.createFoundAnimalReport(report);
    }

    @GetMapping
    public List<FoundAnimalReport> getAllFoundAnimalReports() {
        return foundAnimalReportService.getAllFoundAnimalReports();
    }

    @GetMapping("/{id}")
    public FoundAnimalReport getFoundAnimalReportById(@PathVariable Long id) {
        return foundAnimalReportService.getFoundAnimalReportById(id)
                .orElseThrow(() -> new EntityNotFoundException("Found animal report not found: " + id));
    }

    @PutMapping("/{id}/resolve")
    public FoundAnimalReport resolveFoundAnimalReport(@PathVariable Long id) {
        return foundAnimalReportService.resolveFoundAnimalReport(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFoundAnimalReport(@PathVariable Long id) {
        foundAnimalReportService.deleteFoundAnimalReport(id);
    }
}
