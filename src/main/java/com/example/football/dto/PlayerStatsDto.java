package com.example.football.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerStatsDto {
    private Integer goals;

    private Integer assists;

    private Integer yellowCards;

    private Integer redCards;
}
