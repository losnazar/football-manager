package com.example.footballmanager.controller;

import com.example.footballmanager.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/{playerId}/{teamToId}")
    public String transfer(@PathVariable Long playerId,
                           @PathVariable Long teamToId) {
        transferService.transfer(playerId, teamToId);
        return "Transfer was successfully done! ";
    }
}
