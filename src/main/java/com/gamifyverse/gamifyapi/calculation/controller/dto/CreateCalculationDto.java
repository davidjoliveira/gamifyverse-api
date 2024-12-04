package com.gamifyverse.gamifyapi.calculation.controller.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCalculationDto {
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String name;

	private String description;

	@NotNull
	private UUID gameUUID;

	@NotNull
	private UUID calculationTypeUUID;

	private UUID calculationMathTypeUUID;
	private Double baseValue;

	private UUID calculationTransformationTypeUUID;

	private UUID calculationBonusTypeUUID;
	private Double baseBonusValue;
	private Double upperBonusValue;
}
