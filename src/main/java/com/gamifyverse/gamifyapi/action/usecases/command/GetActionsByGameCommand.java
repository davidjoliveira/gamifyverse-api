package com.gamifyverse.gamifyapi.action.usecases.command;

import java.util.UUID;

import lombok.Value;

@Value
public class GetActionsByGameCommand {
	private UUID gameUUID;
}
