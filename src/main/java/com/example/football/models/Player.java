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
@Table(name = "player")
public class Player extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String t_shirt_number;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private Player_Stats player_stats;

}
