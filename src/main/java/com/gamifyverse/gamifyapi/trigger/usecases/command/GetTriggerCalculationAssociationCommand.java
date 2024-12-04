package com.gamifyverse.gamifyapi.trigger.usecases.command;

import java.util.UUID;

import lombok.Value;

@Value
public class GetTriggerCalculationAssociationCommand {
	private UUID triggerUUID;

	public static GetTriggerCalculationAssociationCommand from(String triggerUUID) {
		return new GetTriggerCalculationAssociationCommand(UUID.fromString(triggerUUID));
	}
}
