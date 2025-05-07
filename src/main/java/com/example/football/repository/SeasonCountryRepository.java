package com.example.football.repository;


import com.example.football.models.SeasonCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SeasonCountryRepository extends JpaRepository<SeasonCountry, UUID> {

    @Query("SELECT sc FROM SeasonCountry sc WHERE sc.season.fromYear = :from AND sc.season.toYear = :to")
    List<SeasonCountry> getSnapshotBySeason(String from, String to);
}
