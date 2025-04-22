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
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer amount_of_players;

//    @OneToOne
//    private Coach coach;
//
//    @OneToOne
//    private Stadium stadium;
//
//    @OneToMany
//    private List<Player> players;

}
