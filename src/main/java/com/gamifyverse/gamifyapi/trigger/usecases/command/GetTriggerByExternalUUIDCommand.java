package com.gamifyverse.gamifyapi.trigger.usecases.command;

import java.util.UUID;

import lombok.Value;

@Value
public class GetTriggerByExternalUUIDCommand {
	private UUID gameUUID;

	public static GetTriggerByExternalUUIDCommand from(String triggerUUID) {
		return new GetTriggerByExternalUUIDCommand(UUID.fromString(triggerUUID));
	}
}
