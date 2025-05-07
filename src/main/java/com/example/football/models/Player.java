package com.example.football.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "player")
public class Player extends Person {

    @Column(nullable = false)
    private String tShirtNumber;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @JsonBackReference
    private Team team;

    @OneToOne
    @JoinColumn(name = "player_stats_id", referencedColumnName = "id")
    @JsonManagedReference
    private PlayerStats playerStats;
}
