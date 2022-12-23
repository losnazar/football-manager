package com.example.footballmanager.dto.team;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class TeamRequestDto {
    @NotBlank
    @Size(max = 25)
    private String name;
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("1000000000.0")
    private BigDecimal account;
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("0.1")
    private double commission;
}
