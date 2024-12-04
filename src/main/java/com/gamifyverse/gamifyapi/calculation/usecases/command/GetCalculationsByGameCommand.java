package com.gamifyverse.gamifyapi.calculation.usecases.command;

import java.util.UUID;

import lombok.Value;

@Value
public class GetCalculationsByGameCommand {
	private UUID gameUUID;

	public static GetCalculationsByGameCommand from(String gameUUID) {
		return new GetCalculationsByGameCommand(UUID.fromString(gameUUID));
	}
}
