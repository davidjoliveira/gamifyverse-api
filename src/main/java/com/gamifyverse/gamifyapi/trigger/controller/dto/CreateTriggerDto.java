package com.gamifyverse.gamifyapi.trigger.controller.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTriggerDto {
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String name;

	private String description;

	@NotNull
	private UUID gameUUID;

	@NotNull
	private UUID actionUUID;

	@NotNull
	private UUID triggerTypeUUID;
	private Integer executionTimes;
	private UUID attributeToIncrementUUID;
	private UUID attributeToCheckUUID;
	private Double attributeValue;

	private UUID triggerEffectTypeUUID;

	private UUID triggerRateTypeUUID;
	private Double baseRate;
	private Double incrementRate;
}
