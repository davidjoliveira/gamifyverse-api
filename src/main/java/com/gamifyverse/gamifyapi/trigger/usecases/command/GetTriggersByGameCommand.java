package com.gamifyverse.gamifyapi.trigger.usecases.command;

import java.util.UUID;

import lombok.Value;

@Value
public class GetTriggersByGameCommand {
	private UUID gameUUID;

	public static GetTriggersByGameCommand from(String gameUUID) {
		return new GetTriggersByGameCommand(UUID.fromString(gameUUID));
	}
}
