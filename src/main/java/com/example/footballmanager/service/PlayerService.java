package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import java.util.List;

public interface PlayerService {
    Player save(Player model);

    Player update(Player model);

    Player findById(Long id);

    List<Player> findAll();

    void deleteById(Long id);

    List<Player> findAllByTeam(Team model);
}
