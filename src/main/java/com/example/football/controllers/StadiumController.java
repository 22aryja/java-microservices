package com.example.football.controllers;
import com.example.football.dto.StadiumDto;
import com.example.football.models.Stadium;
import com.example.football.services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/stadium")
public class StadiumController {

    private final StadiumService stadiumService;

    @Autowired
    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public ResponseEntity<List<Stadium>> getStadium() {
        List<Stadium> stadiums = stadiumService.getStadiums();
        return ResponseEntity.ok(stadiums);
    }

    @GetMapping(path = "{stadiumId}")
    public ResponseEntity<Stadium> getStadium(@PathVariable UUID stadiumId) {
        Stadium stadium = stadiumService.getStadium(stadiumId);
        return ResponseEntity.ok(stadium);
    }

    @PostMapping
    public ResponseEntity<Stadium> createStadium(@ModelAttribute StadiumDto request, @RequestParam UUID teamId) {
        Stadium stadium = stadiumService.createStadium(request, teamId);
        return ResponseEntity.ok(stadium);
    }

    @PatchMapping(path = "{stadiumId}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable UUID stadiumId, @RequestParam StadiumDto request) {
        Stadium stadium = stadiumService.updateStadium(stadiumId, request);
        return ResponseEntity.ok(stadium);
    }

    @DeleteMapping(path = "{stadiumId}")
    public ResponseEntity<Void> deleteStadium(@PathVariable UUID stadiumId) {
        stadiumService.deleteStadium(stadiumId);
        return ResponseEntity.noContent().build();
    }
}
