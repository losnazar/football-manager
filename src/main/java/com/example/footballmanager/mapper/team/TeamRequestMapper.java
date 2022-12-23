package com.example.footballmanager.mapper.team;

import com.example.footballmanager.dto.team.TeamRequestDto;
import com.example.footballmanager.mapper.RequestMapper;
import com.example.footballmanager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamRequestMapper implements RequestMapper<Team, TeamRequestDto> {

    @Override
    public Team toModel(TeamRequestDto dto) {
        Team team = new Team();
        team.setName(dto.getName());
        team.setAccount(dto.getAccount());
        team.setCommission(dto.getCommission());
        return team;
    }
}
