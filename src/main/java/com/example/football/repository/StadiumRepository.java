package com.example.football.repository;

import com.example.football.models.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StadiumRepository extends JpaRepository<UUID, Stadium> {
}
