package com.gamifyverse.gamifyapi.trigger.usecases.command;

import java.util.List;
import java.util.UUID;

import com.gamifyverse.gamifyapi.trigger.controller.dto.AssociateCalculationDto;

import lombok.Value;

@Value
public class CreateTriggerCalculationAssociationCommand {
	private UUID triggerUUID;
	private List<UUID> calculationUUIDs;

	public static CreateTriggerCalculationAssociationCommand from(String triggerUUID, AssociateCalculationDto dto) {
		return new CreateTriggerCalculationAssociationCommand(UUID.fromString(triggerUUID), dto.getCalculations());
	}
}
