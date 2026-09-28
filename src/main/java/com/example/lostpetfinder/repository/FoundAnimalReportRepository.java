package com.example.lostpetfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lostpetfinder.model.FoundAnimalReport;

public interface FoundAnimalReportRepository extends JpaRepository<FoundAnimalReport, Long> {
}
