package com.gamifyverse.gamifyapi.game.service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.game.adapters.GamePersistenceAdapter;
import com.gamifyverse.gamifyapi.game.model.Game;

@Service
public class GameService {

	@Autowired
	private GamePersistenceAdapter gamePersistenceAdapter;

	@Async
	public CompletableFuture<Game> findGame(UUID gameUUID) {
		Optional<Game> game = gamePersistenceAdapter.getGameByExternalUUID(gameUUID);
		return CompletableFuture.<Game>completedFuture(game.orElse(null));
	}

}
