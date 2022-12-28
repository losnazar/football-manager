package com.example.footballmanager.controller;

import com.example.footballmanager.dto.team.TeamRequestDto;
import com.example.footballmanager.dto.team.TeamResponseDto;
import com.example.footballmanager.mapper.RequestMapper;
import com.example.footballmanager.mapper.ResponseMapper;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.TeamService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    private final RequestMapper<Team, TeamRequestDto> requestMapper;
    private final ResponseMapper<TeamResponseDto, Team> responseMapper;

    public TeamController(TeamService teamService,
                          RequestMapper<Team, TeamRequestDto> requestMapper,
                          ResponseMapper<TeamResponseDto, Team> responseMapper) {
        this.teamService = teamService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public TeamResponseDto addTeam(@RequestBody @Valid
                                               TeamRequestDto requestDto) {
        Team team = teamService.save(requestMapper.toModel(requestDto));
        return responseMapper.toDto(team);
    }

    @PutMapping("/{id}")
    public TeamResponseDto updateTeam(@PathVariable Long id,
                                      @RequestBody @Valid
                                              TeamRequestDto teamRequestDto) {
        Team team = requestMapper.toModel(teamRequestDto);
        team.setId(id);
        return responseMapper.toDto(teamService.update(team));
    }

    @GetMapping("/{id}")
    public TeamResponseDto getTeam(@PathVariable Long id) {
        return responseMapper.toDto(teamService.findById(id));
    }

    @GetMapping()
    public List<TeamResponseDto> getAllTeams() {
        List<Team> teams = teamService.findAll();
        return teams.stream()
                .map(responseMapper::toDto)
                .toList();
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamService.deleteById(id);
        return String.format("Team by id: %s, was successfully deleted!", id);
    }
}
