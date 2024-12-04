package com.gamifyverse.gamifyapi.calculation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CalculationTransformationConfiguration {
	private Long id;
	private Calculation calculation;
	private CalculationTransformationType calculationTransformationType;

	public static CalculationTransformationConfiguration createTransformationConfiguration(Calculation calculation,
			CalculationTransformationType calculationTransformationType) {
		if (calculation == null || calculation.getId() == null) {
			throw new RuntimeException(String.format(
					"There must be provided a calculation persisted value to create a transformation configuration"));
		}
		if (calculationTransformationType == null || calculationTransformationType.getId() == null) {
			throw new RuntimeException(String.format(
					"There must be provided a calculation transformation type value to create a transformation configuration for calculation %s",
					calculation.getExternalUUID()));
		}
		return new CalculationTransformationConfiguration(null, calculation, calculationTransformationType);
	}
}
