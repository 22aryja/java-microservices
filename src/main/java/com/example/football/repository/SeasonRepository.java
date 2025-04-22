package com.example.football.repository;

import com.example.football.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeasonRepository extends JpaRepository<UUID, Season> {
}
