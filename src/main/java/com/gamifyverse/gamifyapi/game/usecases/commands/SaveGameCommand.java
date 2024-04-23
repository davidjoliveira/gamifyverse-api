package com.gamifyverse.gamifyapi.game.usecases.commands;

import com.gamifyverse.gamifyapi.game.controller.dto.CreateGameDto;
import com.gamifyverse.gamifyapi.utils.validation.Validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class SaveGameCommand {

	@NotEmpty(message = "O nome do jogo deve ser informado e ter no mínimo 5 e no máximo 15 caracteres")
	@Size(min = 5, max = 15)
	@Valid
	private String name;
	
	private String description;

	public static SaveGameCommand from(@NotNull @Valid CreateGameDto dto) {
		SaveGameCommand command = new SaveGameCommand(dto.getName(), dto.getDescription());
		Validation.validate(command);
		return command;
	}

}
