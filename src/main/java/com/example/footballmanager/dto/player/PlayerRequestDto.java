package com.example.footballmanager.dto.player;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlayerRequestDto {
    @NotBlank
    @Size(max = 25)
    private String firstName;
    @NotBlank
    @Size(max = 25)
    private String lastName;
    @NotNull
    @Min(0)
    @Max(50)
    private int age;
    @NotNull
    @Min(0)
    @Max(300)
    private int monthsOfExperience;
    private Long teamId;
}
