package com.example.footballmanager.service;

import com.example.footballmanager.exception.DataProcessingException;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.TeamRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team save(Team team) {
        String name = team.getName();
        if (teamRepository.findByName(name).isPresent()) {
            throw new DataProcessingException(String
                    .format("Team with name %s already exists in DB.", name));
        }
        return teamRepository.save(team);
    }

    @Override
    public Team update(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team findById(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            return teamOptional.get();
        }
        throw new DataProcessingException(String.format("Team by id: %s, was not found.", id));
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}
