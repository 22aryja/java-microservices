package com.example.football.repository;

import com.example.football.models.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeagueRepository extends JpaRepository<League,UUID> {
}
