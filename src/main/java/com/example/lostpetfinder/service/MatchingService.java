package com.example.lostpetfinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lostpetfinder.model.FoundAnimalReport;
import com.example.lostpetfinder.model.LostPetReport;
import com.example.lostpetfinder.repository.FoundAnimalReportRepository;
import com.example.lostpetfinder.repository.LostPetReportRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MatchingService {

    private final LostPetReportRepository lostPetReportRepository;
    private final FoundAnimalReportRepository foundAnimalReportRepository;

    public MatchingService(LostPetReportRepository lostPetReportRepository,
            FoundAnimalReportRepository foundAnimalReportRepository) {
        this.lostPetReportRepository = lostPetReportRepository;
        this.foundAnimalReportRepository = foundAnimalReportRepository;
    }

    public List<FoundAnimalReport> findMatchesForLostPet(Long lostPetId) {
        LostPetReport lostPetReport = lostPetReportRepository.findById(lostPetId)
                .orElseThrow(() -> new EntityNotFoundException("Lost pet report not found: " + lostPetId));

        List<FoundAnimalReport> matches = new ArrayList<>();
        if (!"LOST".equalsIgnoreCase(lostPetReport.getStatus())) {
            return matches;
        }

        for (FoundAnimalReport foundAnimalReport : foundAnimalReportRepository.findAll()) {
            if (!"FOUND".equalsIgnoreCase(foundAnimalReport.getStatus())) {
                continue;
            }
            if (!sameText(lostPetReport.getSpecies(), foundAnimalReport.getSpecies())) {
                continue;
            }
            if (!sameText(lostPetReport.getLastSeenLocation(), foundAnimalReport.getFoundLocation())) {
                continue;
            }
            if (hasText(lostPetReport.getBreed()) && hasText(foundAnimalReport.getBreed())
                    && !sameText(lostPetReport.getBreed(), foundAnimalReport.getBreed())) {
                continue;
            }
            if (hasText(lostPetReport.getColour()) && hasText(foundAnimalReport.getColour())
                    && !sameText(lostPetReport.getColour(), foundAnimalReport.getColour())) {
                continue;
            }
            matches.add(foundAnimalReport);
        }

        return matches;
    }

    private boolean sameText(String first, String second) {
        return first != null && second != null && first.trim().equalsIgnoreCase(second.trim());
    }

    private boolean hasText(String value) {
        return value != null && !value.isBlank();
    }
}
