package com.example.football.repository;

import com.example.football.models.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerStatsRepository extends JpaRepository<UUID, PlayerStats> {
}
