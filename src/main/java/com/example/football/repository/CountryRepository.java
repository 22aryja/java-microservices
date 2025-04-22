package com.example.football.repository;

import com.example.football.models.Country;
import com.example.football.models.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {

    @Query("SELECT name FROM Country WHERE name = ?1")
    Optional<Country> findCountryByName(String name);

    @Query("SELECT l FROM League l WHERE l.country.id = ?1")
    Optional<League> findLeaguesByCountryId(UUID country_id);

}