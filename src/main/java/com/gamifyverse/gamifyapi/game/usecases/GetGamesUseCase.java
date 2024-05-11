package com.gamifyverse.gamifyapi.game.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.game.adapters.GamePersistenceAdapter;
import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.usecases.commands.GetGameCommand;
import com.gamifyverse.gamifyapi.game.usecases.commands.GetGamesCommand;

@Component
public class GetGamesUseCase {

	@Autowired
	private GamePersistenceAdapter gamePersistence;

	public List<Game> handle(GetGamesCommand command) {
		return gamePersistence.getGames();
	}

	public Game handle(GetGameCommand command) {
		return gamePersistence.getGameByExternalUUID(command.getGameUUID()).orElseThrow(
				() -> new RuntimeException(String.format("Game not found for UUID %s", command.getGameUUID())));
	}

}
