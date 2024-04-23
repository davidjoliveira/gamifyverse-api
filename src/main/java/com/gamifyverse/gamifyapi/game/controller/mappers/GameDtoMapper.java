package com.gamifyverse.gamifyapi.game.controller.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.gamifyverse.gamifyapi.game.controller.dto.CreateGameDto;
import com.gamifyverse.gamifyapi.game.controller.dto.GameDto;
import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.usecases.commands.SaveGameCommand;

@Mapper(componentModel = "spring")
public interface GameDtoMapper {

	public SaveGameCommand toCommand(CreateGameDto dto);

	public GameDto toDto(Game entity);
	
	public List<GameDto> fromListDomain(List<Game> domains);

}
