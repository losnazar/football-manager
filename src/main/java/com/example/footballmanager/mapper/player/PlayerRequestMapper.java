package com.example.footballmanager.mapper.player;

import com.example.footballmanager.dto.player.PlayerRequestDto;
import com.example.footballmanager.mapper.RequestMapper;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class PlayerRequestMapper implements RequestMapper<Player, PlayerRequestDto> {
    private final TeamService teamService;

    public PlayerRequestMapper(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public Player toModel(PlayerRequestDto dto) {
        Player player = new Player();
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setAge(dto.getAge());
        player.setMonthsOfExperience(dto.getMonthsOfExperience());
        Long dtoTeamId = dto.getTeamId();
        if (dtoTeamId != null) {
            Team team = teamService.findById(dtoTeamId);
            player.setTeam(team);
        }
        return player;
    }
}
