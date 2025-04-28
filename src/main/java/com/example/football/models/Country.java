package com.example.football.models;

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
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer worldCups;

    @OneToMany(mappedBy = "country")
    @JsonManagedReference
    private List<League> leagues;

//    @ManyToMany(mappedBy = "countries")
//    private List<Season> seasons;
}
