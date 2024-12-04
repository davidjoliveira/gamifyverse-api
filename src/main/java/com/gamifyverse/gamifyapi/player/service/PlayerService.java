package com.gamifyverse.gamifyapi.player.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.service.GameService;
import com.gamifyverse.gamifyapi.player.model.Player;
import com.gamifyverse.gamifyapi.player.usecases.command.CreatePlayerCommand;

@Service
public class PlayerService {

	@Autowired
	private GameService gameService;

	public Player createPlayerModel(CreatePlayerCommand command) {
		CompletableFuture<Game> gameFuture = gameService.findGame(command.getGameUUID());
		try {
			return Player.from(gameFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(
					String.format("It was not possible to create a proper player due to error %s", e.getMessage()), e);
		}
	}

}
