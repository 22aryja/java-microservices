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
@Table(name = "league")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer amount_of_teams;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

//    @OneToMany
//    private List<Team> teams;

}
