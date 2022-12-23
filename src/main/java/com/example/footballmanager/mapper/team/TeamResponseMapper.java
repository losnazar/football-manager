package com.example.footballmanager.mapper.team;

import com.example.footballmanager.dto.team.TeamResponseDto;
import com.example.footballmanager.mapper.ResponseMapper;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TeamResponseMapper implements ResponseMapper<TeamResponseDto, Team> {
    private final PlayerService playerService;

    public TeamResponseMapper(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public TeamResponseDto toDto(Team model) {
        TeamResponseDto responseDto = new TeamResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setAccount(model.getAccount());
        responseDto.setCommission(model.getCommission());
        List<Player> players = playerService.findAllByTeam(model);
        responseDto.setPlayerIdsList(players.stream()
                .map(Player::getId)
                .toList());
        return responseDto;
    }
}
