package com.gamifyverse.gamifyapi.calculation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationBonusConfiguration {
	private Long id;
	private Calculation calculation;
	private CalculationBonusType calculationBonusType;
	private Double bonusBaseVaue;
	private Double bonusUpperValue;

	public static CalculationBonusConfiguration createBonusConfiguration(Calculation calculation,
			CalculationBonusType calculationBonusType, Double bonusBaseValue, Double bonusUpperValue) {
		if (calculation == null || calculation.getId() == null) {
			throw new RuntimeException(String
					.format("There must be provided a calculation persisted value to create a bonus configuration"));
		}
		if (calculationBonusType == null || calculationBonusType.getId() == null) {
			throw new RuntimeException(String.format(
					"There must be provided a calculation bonus type value to create a bonus configuration for calculation %s",
					calculation.getExternalUUID()));
		}
		if (bonusBaseValue == null || bonusBaseValue <= 0.0) {
			throw new RuntimeException(String.format(
					"There must be provided a valid base value (greater than zero) to create a bonus configuration for calculation %s",
					calculation.getExternalUUID()));
		}
		if (CalculationBonusTypeEnum.fromId(calculationBonusType.getId()) == CalculationBonusTypeEnum.RANGE
				&& (bonusUpperValue == null || bonusUpperValue < bonusBaseValue)) {
			throw new RuntimeException(String.format(
					"There must be provided a valid upper value (greater than base value) to create a bonus configuration for calculation %s",
					calculation.getExternalUUID()));
		}
		return new CalculationBonusConfiguration(null, calculation, calculationBonusType, bonusBaseValue,
				bonusUpperValue);
	}
}
