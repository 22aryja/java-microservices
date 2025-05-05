package com.example.football.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StadiumDto {
    private String name;
    private String city;
    private Integer capacity;
}
