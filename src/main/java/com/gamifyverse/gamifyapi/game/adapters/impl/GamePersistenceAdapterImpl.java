package com.gamifyverse.gamifyapi.game.adapters.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.game.adapters.GamePersistenceAdapter;
import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.model.GameAPIConfiguration;
import com.gamifyverse.gamifyapi.game.repository.GameAPIConfigurationRepository;
import com.gamifyverse.gamifyapi.game.repository.GameRepository;
import com.gamifyverse.gamifyapi.game.repository.entity.GameAPIConfigurationEntity;
import com.gamifyverse.gamifyapi.game.repository.entity.GameEntity;
import com.gamifyverse.gamifyapi.game.repository.mappers.GameEntityMapper;

@Service
public class GamePersistenceAdapterImpl implements GamePersistenceAdapter {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GameAPIConfigurationRepository gameAPIConfigRepository;

	@Autowired
	private GameEntityMapper gameMapper;

	@Override
	public Game upsertGame(Game game) {
		GameEntity entity = gameMapper.fromDomain(game);
		entity = gameRepository.save(entity);
		if (game.getGameAPIConfiguration() != null) {
			GameAPIConfigurationEntity apiEntity = gameMapper.fromDomain(game.getGameAPIConfiguration());
			entity.setApiConfiguration(gameAPIConfigRepository.save(apiEntity));
		}
		return gameMapper.fromEntity(entity);
	}

	@Override
	public GameAPIConfiguration upsertGameAPIConfiguration(GameAPIConfiguration apiConfiguration) {
		GameAPIConfigurationEntity apiEntity = gameMapper.fromDomain(apiConfiguration);
		apiEntity = gameAPIConfigRepository.save(apiEntity);
		return gameMapper.fromEntity(apiEntity);
	}

	@Override
	public List<Game> getGames() {
		return gameMapper.fromListEntity(gameRepository.findAll());
	}

}
