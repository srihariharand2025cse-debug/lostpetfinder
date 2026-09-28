package com.example.lostpetfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lostpetfinder.model.LostPetReport;

public interface LostPetReportRepository extends JpaRepository<LostPetReport, Long> {
}
