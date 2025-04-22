package com.example.football.controllers;
import com.example.football.models.Country;
import com.example.football.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping(path = "{countryId}")
    Country getCountry(@PathVariable("countryId")UUID countryId) {
        return countryService.getCountryById(countryId);
    }

    @PostMapping
    public Country createCountry(@RequestParam String name, @RequestParam Integer worldCups) {
        return countryService.addCountry(name, worldCups);
    }

    @PatchMapping(path = "{countryId}")
    public Country updateCountry(@PathVariable UUID countryId, @RequestParam String name, @RequestParam Integer worldCups) {
        return countryService.updateCountry(countryId, name, worldCups);
    }

    @DeleteMapping(path = "{countryId}")
    public void deleteCountry(@PathVariable UUID countryId) {
        countryService.deleteCountry(countryId);
    }
}