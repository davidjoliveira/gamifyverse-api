package com.gamifyverse.gamifyapi.calculation.service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.calculation.adapters.CalculationPersistenceAdapter;
import com.gamifyverse.gamifyapi.calculation.adapters.CalculationTypesValuesPersistenceAdapter;
import com.gamifyverse.gamifyapi.calculation.model.Calculation;
import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationType;
import com.gamifyverse.gamifyapi.calculation.usecases.command.CreateCalculationCommand;
import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.service.GameService;

@Service
public class CalculationService {

	@Autowired
	private GameService gameService;

	@Autowired
	private CalculationTypesValuesPersistenceAdapter typesValuesPersistenceAdapter;

	@Autowired
	private CalculationPersistenceAdapter calculationPersistenceAdapter;

	@Async
	public CompletableFuture<CalculationType> findCalculationType(UUID calculationTypeUUID) {
		Optional<CalculationType> calculationType = typesValuesPersistenceAdapter
				.findCalculationTypeByUUID(calculationTypeUUID);
		return CompletableFuture.<CalculationType>completedFuture(calculationType.orElse(null));
	}

	@Async
	public CompletableFuture<Calculation> findCalculation(UUID calculationUUID) {
		Optional<Calculation> calculation = calculationPersistenceAdapter.getCalculationByExternalUUID(calculationUUID);
		return CompletableFuture.<Calculation>completedFuture(calculation.orElse(null));
	}

	public CalculationMathConfiguration createCalculationMathConfiguration(Calculation calculation,
			CreateCalculationCommand command) {
		Optional<CalculationMathType> mathType = typesValuesPersistenceAdapter
				.findCalculationMathTypeByUUID(command.getCalculationMathTypeUUID());
		CalculationMathConfiguration mathConfig = CalculationMathConfiguration.createMathConfiguration(calculation,
				mathType.orElse(null), command.getCalculationMathBaseValue());
		return mathConfig;
	}

	public CalculationTransformationConfiguration createCalculationTransformationConfiguration(Calculation calculation,
			CreateCalculationCommand command) {
		Optional<CalculationTransformationType> transformationType = typesValuesPersistenceAdapter
				.findCalculationTransformationTypeByUUID(command.getCalculationTransformationTypeUUID());
		CalculationTransformationConfiguration transformationConfig = CalculationTransformationConfiguration
				.createTransformationConfiguration(calculation, transformationType.orElse(null));
		return transformationConfig;
	}

	public CalculationBonusConfiguration createCalculationBonusConfiguration(Calculation calculation,
			CreateCalculationCommand command) {
		Optional<CalculationBonusType> bonusType = typesValuesPersistenceAdapter
				.findCalculationBonusTypeByUUID(command.getCalculationBonusTypeUUID());
		CalculationBonusConfiguration bonusConfig = CalculationBonusConfiguration.createBonusConfiguration(calculation,
				bonusType.orElse(null), command.getCalculationBonusBaseValue(),
				command.getCalculationBonusUpperValue());
		return bonusConfig;
	}

	public Calculation createCalculation(CreateCalculationCommand command) {
		CompletableFuture<Game> gameFuture = gameService.findGame(command.getGameUUID());
		CompletableFuture<CalculationType> calculationTypeFuture = this
				.findCalculationType(command.getCalculationTypeUUID());

		try {
			return CompletableFuture.allOf(gameFuture, calculationTypeFuture)
					.thenApply(v -> Calculation.createCalculation(command.getName(), command.getDescription(),
							gameFuture.join(), calculationTypeFuture.join()))
					.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(
					String.format("It was not possible to create a proper calculation due to error %s", e.getMessage()),
					e);
		}
	}

}
