package com.gamifyverse.gamifyapi.attributes.usecases.command;

import java.util.UUID;

import lombok.Value;

@Value
public class GetAttributesByGameUUIDCommand {
	private UUID gameUUID;
}
