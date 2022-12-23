package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl implements TransferService {
    private final PlayerServiceImpl playerServiceImpl;
    private final TeamService teamService;

    public TransferServiceImpl(PlayerServiceImpl playerServiceImpl,
                               TeamService teamService) {
        this.playerServiceImpl = playerServiceImpl;
        this.teamService = teamService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transfer(Long playerId, Long teamToId) {
        Team teamTo = teamService.findById(teamToId);
        Player player = playerServiceImpl.findById(playerId);
        Team teamFrom = player.getTeam();

        int transferCost = player.getMonthsOfExperience() * 100000 / player.getAge();
        int commission = (int) (teamFrom.getCommission() * transferCost);
        int fullTransferCost = transferCost + commission;

        BigDecimal accountFromBeforeTransfer = teamFrom.getAccount();
        BigDecimal accountFromAfterTransfer = accountFromBeforeTransfer
                .add(BigDecimal.valueOf(fullTransferCost));
        teamFrom.setAccount(accountFromAfterTransfer);
        teamService.update(teamFrom);

        BigDecimal accountToBeforeTransfer = teamTo.getAccount();
        BigDecimal accountToAfterTransfer = accountToBeforeTransfer
                .subtract(BigDecimal.valueOf(fullTransferCost));
        teamTo.setAccount(accountToAfterTransfer);
        teamService.update(teamTo);

        player.setTeam(teamTo);
        playerServiceImpl.update(player);
    }
}
