package com.example.football.repository;

import com.example.football.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface SeasonRepository extends JpaRepository<Season, UUID> {

    @Query("SELECT s FROM Season s WHERE s.fromYear = :from AND s.toYear = :to")
    Optional<Season> findSeasonByYears(String from, String to);
}
