package com.gamifyverse.gamifyapi.game.repository.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.model.GameAPIConfiguration;
import com.gamifyverse.gamifyapi.game.repository.entity.GameAPIConfigurationEntity;
import com.gamifyverse.gamifyapi.game.repository.entity.GameEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GameEntityMapper {

	public List<Game> fromListEntity(List<GameEntity> games);
	
	public Game fromEntity(GameEntity entity);

	public GameEntity fromDomain(Game domain);

	@Mapping(target = "game", expression = "java(getGameById(domain.getGameId()))")
	public GameAPIConfigurationEntity fromDomain(GameAPIConfiguration domain);

	@Mapping(target = "gameId", source = "entity.game.id")
	public GameAPIConfiguration fromEntity(GameAPIConfigurationEntity entity);

	public default GameEntity getGameById(Long gameId) {
		GameEntity g = new GameEntity();
		g.setId(gameId);
		return g;
	}

}
