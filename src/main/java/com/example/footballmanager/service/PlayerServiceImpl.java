package com.example.footballmanager.service;

import com.example.footballmanager.exception.DataProcessingException;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.PlayerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamService teamService;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             TeamService teamService) {
        this.playerRepository = playerRepository;
        this.teamService = teamService;
    }

    @Override
    public Player save(Player player) {
        String firstName = player.getFirstName();
        String lastName = player.getLastName();
        if (playerRepository.findByFirstNameAndLastName(firstName, lastName).isPresent()) {
            throw new DataProcessingException(String.format("Player with firstName: "
                    + "%s, and lastName: %s, already exists in DB",
                    firstName, lastName));
        }
        return playerRepository.save(player);
    }

    @Override
    public Player update(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player findById(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            return optionalPlayer.get();
        } else {
            throw new DataProcessingException(String
                    .format("Player by id: %s, was not found!", id));
        }
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public List<Player> findAllByTeam(Team team) {
        return playerRepository.findAllByTeam(team);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
