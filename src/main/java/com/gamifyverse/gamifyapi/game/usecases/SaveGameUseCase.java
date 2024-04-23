package com.gamifyverse.gamifyapi.game.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.game.adapters.GamePersistenceAdapter;
import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.usecases.commands.SaveGameCommand;

import jakarta.transaction.Transactional;

@Component
public class SaveGameUseCase {

	@Autowired
	private GamePersistenceAdapter gamePersistence;

	@Transactional
	public Game handle(SaveGameCommand command) {
		Game game = Game.newGame(command.getName(), command.getDescription());
		game = gamePersistence.upsertGame(game);
		game = game.createConfiguration();
		gamePersistence.upsertGameAPIConfiguration(game.getGameAPIConfiguration());
		return game;
	}

}
