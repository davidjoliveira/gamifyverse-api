package com.gamifyverse.gamifyapi.calculation.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gamifyverse.gamifyapi.calculation.model.Calculation;
import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationConfiguration;

public interface CalculationPersistenceAdapter {

	public Calculation persistCalculation(Calculation calculation);

	public CalculationMathConfiguration persistCalculationMathConfiguration(CalculationMathConfiguration mathConfig);

	public CalculationTransformationConfiguration persistCalculationTransformationConfiguration(
			CalculationTransformationConfiguration transformationConfig);

	public CalculationBonusConfiguration persistCalculationBonusConfiguration(
			CalculationBonusConfiguration bonusConfig);

	public List<Calculation> getCalculationsByGameUUID(UUID gameUUID);
	
	public Optional<Calculation> getCalculationByExternalUUID(UUID calculationUUID);

}
