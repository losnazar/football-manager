package com.example.footballmanager.controller;

import com.example.footballmanager.dto.player.PlayerRequestDto;
import com.example.footballmanager.dto.player.PlayerResponseDto;
import com.example.footballmanager.mapper.RequestMapper;
import com.example.footballmanager.mapper.ResponseMapper;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
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
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final RequestMapper<Player, PlayerRequestDto> requestMapper;
    private final ResponseMapper<PlayerResponseDto, Player> responseMapper;

    public PlayerController(PlayerService playerService,
                            RequestMapper<Player, PlayerRequestDto> requestMapper,
                            ResponseMapper<PlayerResponseDto, Player> responseMapper) {
        this.playerService = playerService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public PlayerResponseDto addPlayer(@RequestBody @Valid
                                                   PlayerRequestDto playerRequestDto) {
        Player player = playerService.save(requestMapper.toModel(playerRequestDto));
        return responseMapper.toDto(player);
    }

    @PutMapping("/{id}")
    public PlayerResponseDto updatePlayer(@PathVariable Long id,
                                          @RequestBody @Valid
                                                  PlayerRequestDto playerRequestDto) {
        Player player = requestMapper.toModel(playerRequestDto);
        player.setId(id);
        return responseMapper.toDto(playerService.update(player));
    }

    @GetMapping("/{id}")
    public PlayerResponseDto getPlayer(@PathVariable Long id) {
        return responseMapper.toDto(playerService.findById(id));
    }

    @GetMapping
    public List<PlayerResponseDto> getAllPlayers() {
        List<Player> players = playerService.findAll();
        return players.stream()
                .map(responseMapper::toDto)
                .toList();
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return String.format("Player by id: %s, was successfully deleted!", id);
    }
}
