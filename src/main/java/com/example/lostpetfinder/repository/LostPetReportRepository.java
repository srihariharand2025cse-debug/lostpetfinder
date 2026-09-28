package com.example.lostpetfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lostpetfinder.model.LostPetReport;

public interface LostPetReportRepository extends JpaRepository<LostPetReport, Long> {

	List<LostPetReport> findByLastSeenLocationContainingIgnoreCase(String location);
}
