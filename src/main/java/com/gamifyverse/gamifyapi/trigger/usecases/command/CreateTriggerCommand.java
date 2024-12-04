package com.gamifyverse.gamifyapi.trigger.usecases.command;

import java.util.UUID;

import com.gamifyverse.gamifyapi.trigger.controller.dto.CreateTriggerDto;

import lombok.Value;

@Value
public class CreateTriggerCommand {
	private String name;
	private String description;
	private UUID gameUUID;
	private UUID actionUUID;
	private UUID triggerTypeUUID;
	private Integer executionTImes;
	private UUID attributeToIncrementUUID;
	private UUID attributeToCheckUUID;
	private Double attributeValue;
	private UUID triggerEffectTypeUUID;
	private UUID triggerRateTypeUUID;
	private Double baseRate;
	private Double incrementRate;

	public static CreateTriggerCommand from(CreateTriggerDto dto) {
		return new CreateTriggerCommand(dto.getName(), dto.getDescription(), dto.getGameUUID(), dto.getActionUUID(),
				dto.getTriggerTypeUUID(), dto.getExecutionTimes(), dto.getAttributeToIncrementUUID(),
				dto.getAttributeToCheckUUID(), dto.getAttributeValue(), dto.getTriggerEffectTypeUUID(),
				dto.getTriggerRateTypeUUID(), dto.getBaseRate(), dto.getIncrementRate());
	}
}
