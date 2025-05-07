package com.example.football.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private Player_Stats player_stats;

}
