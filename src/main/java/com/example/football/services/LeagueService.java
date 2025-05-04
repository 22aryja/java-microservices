package com.example.football.services;

import com.example.football.models.Country;
import com.example.football.models.League;
import com.example.football.repository.CountryRepository;
import com.example.football.repository.LeagueRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;
    private final CountryRepository countryRepository;

    public LeagueService(LeagueRepository leagueRepository, CountryRepository countryRepository) {
        this.leagueRepository = leagueRepository;
        this.countryRepository = countryRepository;
    }

    public List<League> getLeagues() {
        return leagueRepository.findAllLeagueWithTeams();
    }

    public League getLeagueById(UUID leagueId){
        return leagueRepository.findLeagueWithTeamsById(leagueId).orElseThrow(
                () -> new EntityNotFoundException("Country not found with id: " + leagueId)
        );
    }

    @Transactional
    public League createLeague(String name, Integer amountOfTeams, UUID countryId){
        Optional<League> possibleLeague = leagueRepository.findLeagueByName(name);
        possibleLeague.ifPresent(league -> {throw new IllegalStateException("Such league already exists");});

        League newLeague = new League();
        newLeague.setName(name);
        newLeague.setAmountOfTeams(amountOfTeams);
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + countryId));
        newLeague.setCountry(country);

        return leagueRepository.save(newLeague);
    }

    @Transactional
    public League updateLeague(UUID leagueId, String name, Integer amountOfTeams) {
        Optional<League> possibleLeague = leagueRepository.findById(leagueId);

        if (possibleLeague.isPresent()) {
            League foundLeague = possibleLeague.get();

            foundLeague.setName(name);
            foundLeague.setAmountOfTeams(amountOfTeams);

            return leagueRepository.save(foundLeague);
        } else {
            throw new EntityNotFoundException("Country not found with id: " + leagueId);
        }
    }

    public void deleteLeague(UUID leagueId) {
        if (!leagueRepository.existsById(leagueId)) {
            throw new EntityNotFoundException("League with id " + leagueId + " not found");
        }
        leagueRepository.deleteById(leagueId);
    }
}
