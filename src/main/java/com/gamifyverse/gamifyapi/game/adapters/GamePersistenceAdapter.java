package com.gamifyverse.gamifyapi.game.adapters;

import java.util.List;

import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.model.GameAPIConfiguration;

public interface GamePersistenceAdapter {
	
	public Game upsertGame(Game game);
	
	public List<Game> getGames();
	
	public GameAPIConfiguration upsertGameAPIConfiguration(GameAPIConfiguration apiConfiguration);
	
}
