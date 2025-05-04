package com.example.football.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    private Integer amountOfTeams;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    @JsonBackReference
    private Country country;

    @OneToMany(mappedBy = "league")
    @JsonManagedReference
    private List<Team> teams;

}
