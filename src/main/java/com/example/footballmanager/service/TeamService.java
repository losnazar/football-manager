package com.example.footballmanager.service;

import com.example.footballmanager.model.Team;
import java.util.List;

public interface TeamService {
    Team save(Team team);

    Team update(Team team);

    Team findById(Long id);

    List<Team> findAll();

    void deleteById(Long id);
}
