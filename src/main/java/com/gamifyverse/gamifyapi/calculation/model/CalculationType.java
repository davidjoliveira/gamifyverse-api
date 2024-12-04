package com.gamifyverse.gamifyapi.calculation.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationType {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;

	public boolean hasToCreateMathConfiguration() {
		CalculationTypeEnum v = CalculationTypeEnum.fromId(id);
		return v == CalculationTypeEnum.MATH;
	}

	public boolean hasToCreateTransformationConfiguration() {
		CalculationTypeEnum v = CalculationTypeEnum.fromId(id);
		return v == CalculationTypeEnum.TRANSFORMATION;
	}

	public boolean hasToCreateBonusConfiguration() {
		CalculationTypeEnum v = CalculationTypeEnum.fromId(id);
		return v == CalculationTypeEnum.BONUS;
	}

}
