package com.gamifyverse.gamifyapi.calculation.controller.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class CalculationDto {
	private String name;
	private String description;
	private UUID externalUUID;
	private UUID gameUUID;
	private UUID calculationTypeUUID;
	private UUID calculationMathTypeUUID;
	private Double baseValue;
	private UUID calculationTransformationTypeUUID;
	private UUID calculationBonusTypeUUID;
	private Double baseBonusValue;
	private Double upperBonusValue;
	private LocalDateTime creationDate;
}
