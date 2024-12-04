package com.gamifyverse.gamifyapi.calculation.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gamifyverse.gamifyapi.game.model.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculation {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
	private Game game;
	private CalculationType calculationType;
	private CalculationMathConfiguration calculationMath;
	private CalculationTransformationConfiguration calculationTransformation;
	private CalculationBonusConfiguration calculationBonus;
	private LocalDateTime creationDate;

	public static Calculation createCalculation(String name, String description, Game game,
			CalculationType calculationType) {
		if (game == null) {
			throw new RuntimeException("You must provide a game to associate on calculation creation");
		}
		if (calculationType == null) {
			throw new RuntimeException("You must provide a calculation type to associate on calculation creation");
		}
		return new Calculation(null, name, description, UUID.randomUUID(), game, calculationType, null, null, null,
				LocalDateTime.now());
	}

	public boolean hasToCreateMathConfiguration() {
		return calculationType.hasToCreateMathConfiguration();
	}

	public boolean hasToCreateTransformationConfiguration() {
		return calculationType.hasToCreateTransformationConfiguration();
	}

	public boolean hasToCreateBonusConfiguration() {
		return calculationType.hasToCreateBonusConfiguration();
	}

}
