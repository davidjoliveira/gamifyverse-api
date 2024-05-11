package com.gamifyverse.gamifyapi.game.usecases.commands;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class GetGameCommand {
	@NotNull
	private UUID gameUUID;
}
