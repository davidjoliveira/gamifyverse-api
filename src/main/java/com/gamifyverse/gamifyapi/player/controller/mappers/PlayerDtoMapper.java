package com.gamifyverse.gamifyapi.player.controller.mappers;

import org.mapstruct.Mapper;

import com.gamifyverse.gamifyapi.game.repository.mappers.GameEntityMapper;
import com.gamifyverse.gamifyapi.player.controller.dto.PlayerDto;
import com.gamifyverse.gamifyapi.player.model.Player;

@Mapper(componentModel = "spring", uses = { GameEntityMapper.class })
public interface PlayerDtoMapper {

	public PlayerDto toDto(Player domain);

}
