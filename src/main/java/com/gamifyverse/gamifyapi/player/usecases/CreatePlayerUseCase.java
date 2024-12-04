package com.gamifyverse.gamifyapi.player.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.player.adapters.PlayerPersistenceAdapter;
import com.gamifyverse.gamifyapi.player.model.Player;
import com.gamifyverse.gamifyapi.player.service.PlayerService;
import com.gamifyverse.gamifyapi.player.usecases.command.CreatePlayerCommand;

@Service
public class CreatePlayerUseCase {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlayerPersistenceAdapter playerPersistenceAdapter;

	public Player handle(CreatePlayerCommand command) {
		Player player = playerService.createPlayerModel(command);
		return playerPersistenceAdapter.createPlayer(player);
	}

}
