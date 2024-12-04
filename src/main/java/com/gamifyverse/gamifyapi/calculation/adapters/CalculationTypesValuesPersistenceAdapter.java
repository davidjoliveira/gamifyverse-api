package com.gamifyverse.gamifyapi.calculation.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationOriginValueType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationType;

public interface CalculationTypesValuesPersistenceAdapter {
	public List<CalculationType> findAllCalculationTypes();
	public Optional<CalculationType> findCalculationTypeByUUID(UUID calculationTypeUUID);

	public List<CalculationMathType> findAllCalculationMathTypes();
	public Optional<CalculationMathType> findCalculationMathTypeByUUID(UUID calculationMathTypeUUID);

	public List<CalculationTransformationType> findAllCalculationTransformationTypes();
	public Optional<CalculationTransformationType> findCalculationTransformationTypeByUUID(
			UUID calculationTransformationType);

	public List<CalculationBonusType> findAllCalculationBonusTypes();
	public Optional<CalculationBonusType> findCalculationBonusTypeByUUID(UUID calculationBonusTypeUUID);

	public Optional<CalculationOriginValueType> findCalculationOriginValueTypeByUUID(
			UUID calculationOriginValueTypeUUID);

}
