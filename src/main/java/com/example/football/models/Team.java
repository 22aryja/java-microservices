package com.example.football.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer amountOfPlayers;

    @ManyToOne
    @JoinColumn(name = "league_id", nullable = false)
    @JsonBackReference
    private League league;

//    @OneToMany
//    private List<Player> players;

//    @OneToOne
//    private Coach coach;
//
//    @OneToOne
//    private Stadium stadium;
//
}
