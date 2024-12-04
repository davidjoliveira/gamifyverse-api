package com.gamifyverse.gamifyapi.trigger.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class TriggerCalculationAssociationDto {
	private UUID triggerUUID;
	private UUID calculationUUID;
	private Integer order;
}
