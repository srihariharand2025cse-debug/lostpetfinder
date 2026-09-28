package com.example.lostpetfinder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lostpetfinder.model.FoundAnimalReport;
import com.example.lostpetfinder.service.MatchingService;

@RestController
@RequestMapping("/api/matches")
public class MatchingController {

    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping("/lost/{lostPetId}")
    public List<FoundAnimalReport> findMatchesForLostPet(@PathVariable Long lostPetId) {
        return matchingService.findMatchesForLostPet(lostPetId);
    }
}
