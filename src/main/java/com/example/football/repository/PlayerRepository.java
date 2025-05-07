package com.example.football.repository;

import com.example.football.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

    @Query("SELECT p FROM Player p WHERE p.team.id = :teamId")
    List<Player> getAllPlayersInTeam(UUID teamId);

}
