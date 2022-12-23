package com.example.footballmanager.mapper.player;

import com.example.footballmanager.dto.player.PlayerResponseDto;
import com.example.footballmanager.mapper.ResponseMapper;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class PlayerResponseMapper implements ResponseMapper<PlayerResponseDto, Player> {

    @Override
    public PlayerResponseDto toDto(Player model) {
        PlayerResponseDto responseDto = new PlayerResponseDto();
        responseDto.setId(model.getId());
        responseDto.setFirstName(model.getFirstName());
        responseDto.setLastName(model.getLastName());
        responseDto.setAge(model.getAge());
        responseDto.setMonthsOfExperience(model.getMonthsOfExperience());
        Team team = model.getTeam();
        if (team != null) {
            responseDto.setTeamId(team.getId());
        }
        return responseDto;
    }
}
