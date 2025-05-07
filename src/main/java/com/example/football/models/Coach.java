package com.example.football.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "coach")
public class Coach extends Person {

    @OneToOne
    private Country country_from;
}
