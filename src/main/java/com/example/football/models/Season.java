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
@Table(name = "season")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String from_year;

    @Column(nullable = false)
    private String to_year;

//    @ManyToMany
//    @JoinTable(
//            name = "season_country",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id")
//    )
//    private List<Country> countries;

 }
