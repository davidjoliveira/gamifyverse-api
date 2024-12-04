package com.gamifyverse.gamifyapi.calculation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CalculationMathConfiguration {
	private Long id;
	private Calculation calculation;
	private CalculationMathType calculationMathType;
	private Double baseValue;

	public static CalculationMathConfiguration createMathConfiguration(Calculation calculation,
			CalculationMathType calculationMathType, Double baseValue) {
		if (calculation == null || calculation.getId() == null) {
			throw new RuntimeException(String
					.format("There must be provided a calculation persisted value to create a math configuration"));
		}
		if (calculationMathType == null || calculationMathType.getId() == null) {
			throw new RuntimeException(String.format(
					"There must be provided a calculation math type value to create a math configuration for calculation %s",
					calculation.getExternalUUID()));
		}
		if (baseValue == null || baseValue <= 0.0) {
			throw new RuntimeException(String.format(
					"There must be provided a valid base value (greater than zero) to create a math configuration for calculation %s",
					calculation.getExternalUUID()));
		}
		return new CalculationMathConfiguration(null, calculation, calculationMathType, baseValue);
	}
}
