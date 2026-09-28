package com.example.lostpetfinder.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lost_pet_reports")
public class LostPetReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String species;
    private String breed;
    private String colour;
    private String lastSeenLocation;
    private LocalDate reportDate;
    private String status;

    public LostPetReport() {
    }

    public LostPetReport(String species, String breed, String colour, String lastSeenLocation,
            LocalDate reportDate, String status) {
        this.species = species;
        this.breed = breed;
        this.colour = colour;
        this.lastSeenLocation = lastSeenLocation;
        this.reportDate = reportDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLastSeenLocation() {
        return lastSeenLocation;
    }

    public void setLastSeenLocation(String lastSeenLocation) {
        this.lastSeenLocation = lastSeenLocation;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
