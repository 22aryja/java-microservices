package com.example.football.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "player_stats")
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Integer goals;

    @Column(nullable = false)
    private Integer assists;

    @Column(nullable = false)
    private Integer yellow_cards;

    @Column(nullable = false)
    private Integer red_cards;
}
