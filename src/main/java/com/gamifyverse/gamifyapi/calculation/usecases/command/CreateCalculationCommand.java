package com.gamifyverse.gamifyapi.calculation.usecases.command;

import java.util.UUID;

import com.gamifyverse.gamifyapi.calculation.controller.dto.CreateCalculationDto;

import lombok.Value;

@Value
public class CreateCalculationCommand {
	private String name;
	private String description;
	private UUID gameUUID;
	private UUID calculationTypeUUID;

	private UUID calculationMathTypeUUID;
	private Double calculationMathBaseValue;

	private UUID calculationTransformationTypeUUID;

	private UUID calculationBonusTypeUUID;
	private Double calculationBonusBaseValue;
	private Double calculationBonusUpperValue;

	public static CreateCalculationCommand from(String name, String description, UUID gameUUID,
			UUID calculationTypeUUID, UUID calculationMathTypeUUID, Double calculationMathBaseValue,
			UUID calculationTransformationTypeUUID, UUID calculationBonusTypeUUID, Double calculationBonusBaseValue,
			Double calculationBonusUpperValue) {
		return new CreateCalculationCommand(name, description, gameUUID, calculationTypeUUID, calculationMathTypeUUID,
				calculationMathBaseValue, calculationTransformationTypeUUID, calculationBonusTypeUUID,
				calculationBonusBaseValue, calculationBonusUpperValue);
	}

	public static CreateCalculationCommand from(CreateCalculationDto dto) {
		return from(dto.getName(), dto.getDescription(), dto.getGameUUID(), dto.getCalculationTypeUUID(),
				dto.getCalculationMathTypeUUID(), dto.getBaseValue(), dto.getCalculationTransformationTypeUUID(),
				dto.getCalculationBonusTypeUUID(), dto.getBaseBonusValue(), dto.getUpperBonusValue());
	}

}
