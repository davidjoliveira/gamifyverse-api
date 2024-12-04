package com.gamifyverse.gamifyapi.player.adapters.mappers;

import org.mapstruct.Mapper;

import com.gamifyverse.gamifyapi.game.repository.mappers.GameEntityMapper;
import com.gamifyverse.gamifyapi.player.model.Player;
import com.gamifyverse.gamifyapi.player.repository.entity.PlayerEntity;

@Mapper(componentModel = "spring", uses = { GameEntityMapper.class })
public interface PlayerEntityMapper {

	public Player toDomain(PlayerEntity entity);

	public PlayerEntity toEntity(Player domain);

}
