package com.example.footballmanager.dto.team;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TeamResponseDto {
    private Long id;
    private String name;
    private BigDecimal account;
    private double commission;
    private List<Long> playerIdsList;
}
