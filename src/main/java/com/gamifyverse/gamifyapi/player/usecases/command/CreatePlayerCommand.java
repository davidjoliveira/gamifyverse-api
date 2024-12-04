package com.gamifyverse.gamifyapi.player.usecases.command;

import java.util.UUID;

import com.gamifyverse.gamifyapi.player.controller.dto.PlayerDto;

import jakarta.validation.Valid;
import lombok.Value;

@Value
public class CreatePlayerCommand {
	private UUID gameUUID;

	public static CreatePlayerCommand from(@Valid PlayerDto body) {
		return new CreatePlayerCommand(body.getGameUUID());
	}
}
