package com.example.football.repository;

import com.example.football.models.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface LeagueRepository extends JpaRepository<League,UUID> {

    @Query("SELECT name from League WHERE name = ?1")
    Optional<League> findLeagueByName(String name);
}
