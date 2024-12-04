package com.gamifyverse.gamifyapi.calculation.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.calculation.adapters.CalculationPersistenceAdapter;
import com.gamifyverse.gamifyapi.calculation.model.Calculation;
import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationConfiguration;
import com.gamifyverse.gamifyapi.calculation.service.CalculationService;
import com.gamifyverse.gamifyapi.calculation.usecases.command.CreateCalculationCommand;

import jakarta.transaction.Transactional;

@Component
public class CreateCalculationUseCase {

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private CalculationPersistenceAdapter calculationPersistenceAdapter;

	private void handleCreateMathConfiguration(Calculation calculation, CreateCalculationCommand command) {
		if (!calculation.hasToCreateMathConfiguration()) {
			return;
		}
		CalculationMathConfiguration mathConfig = calculationService.createCalculationMathConfiguration(calculation,
				command);
		calculationPersistenceAdapter.persistCalculationMathConfiguration(mathConfig);
		calculation.setCalculationMath(mathConfig);
	}

	private void handleCreateTransformationConfiguration(Calculation calculation, CreateCalculationCommand command) {
		if (!calculation.hasToCreateTransformationConfiguration()) {
			return;
		}
		CalculationTransformationConfiguration transformationConfig = calculationService
				.createCalculationTransformationConfiguration(calculation, command);
		calculationPersistenceAdapter.persistCalculationTransformationConfiguration(transformationConfig);
		calculation.setCalculationTransformation(transformationConfig);
	}

	private void handleCreateBonusConfiguration(Calculation calculation, CreateCalculationCommand command) {
		if (!calculation.hasToCreateBonusConfiguration()) {
			return;
		}
		CalculationBonusConfiguration bonusConfig = calculationService.createCalculationBonusConfiguration(calculation,
				command);
		calculationPersistenceAdapter.persistCalculationBonusConfiguration(bonusConfig);
		calculation.setCalculationBonus(bonusConfig);
	}

	@Transactional
	public Calculation handle(CreateCalculationCommand command) {
		Calculation calculation = calculationService.createCalculation(command);
		calculation = calculationPersistenceAdapter.persistCalculation(calculation);
		this.handleCreateMathConfiguration(calculation, command);
		this.handleCreateTransformationConfiguration(calculation, command);
		this.handleCreateBonusConfiguration(calculation, command);
		return calculation;
	}

}
