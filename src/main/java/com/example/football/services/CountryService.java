package com.example.football.services;
import com.example.football.models.Country;
import com.example.football.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(UUID id) {
        return countryRepository.getById(id);
    }

    public Country createCountry(Country country) {
        Optional<Country> possibleCountry =  countryRepository.findCountryByName(country.getName());
        possibleCountry.ifPresent(foundCountry -> {
            throw new IllegalStateException("Such country already exists");
        });

        return countryRepository.save(country);
    }

    public Country updateCountry(String name, Integer worldCups) {

    }
}
