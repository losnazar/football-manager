package com.example.footballmanager.repository;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByFirstNameAndLastName(String firstName,
                                               String lastName);

    List<Player> findAllByTeam(Team team);
}
