package com.gamifyverse.gamifyapi.calculation.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.gamifyverse.gamifyapi.calculation.model.*;
import com.gamifyverse.gamifyapi.calculation.repository.entity.*;
import com.gamifyverse.gamifyapi.game.repository.mappers.GameEntityMapper;

@Named("CalculationMapper")
@Mapper(componentModel = "spring", uses = {
		GameEntityMapper.class }, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CalculationEntityMapper {

	// Calculation types
	public CalculationType toDomain(CalculationTypeEntity entity);

	public List<CalculationType> toCalculationTypeDomainList(List<CalculationTypeEntity> entities);

	// Calculation origin value types
	public CalculationOriginValueType toDomain(CalculationOriginValueTypeEntity entity);

	public List<CalculationOriginValueType> toCalculationOriginValueTypeDomainList(
			List<CalculationOriginValueTypeEntity> entities);

	// Calculation transformation types
	public CalculationTransformationType toDomain(CalculationTransformationTypeEntity entity);

	public List<CalculationTransformationType> toCalculationTransformationTypeDomainList(
			List<CalculationTransformationTypeEntity> entities);

	// Calculation bonus types
	public CalculationBonusType toDomain(CalculationBonusTypeEntity entity);

	public List<CalculationBonusType> toCalculationBonusTypeDomainList(List<CalculationBonusTypeEntity> entities);

	// Calculation
	@Named("toCalculationEntity")
	public CalculationEntity toEntity(Calculation domain);

	@Named("toCalculationDomain")
	@Mapping(target = "calculationBonus", qualifiedByName = { "toCalculationBonusWithoutCalculation" })
	@Mapping(target = "calculationMath", qualifiedByName = { "toCalculationMathWithoutCalculation" })
	@Mapping(target = "calculationTransformation", qualifiedByName = {
			"toCalculationTransformationWithoutCalculation" })
	public Calculation toDomain(CalculationEntity entity);

	// Calculation bonus configuration
	public CalculationBonusConfigurationEntity toEntity(CalculationBonusConfiguration domain);

	public CalculationBonusConfiguration toDomain(CalculationBonusConfigurationEntity entity);

	@Named("toCalculationBonusWithoutCalculation")
	@Mapping(target = "calculation", ignore = true)
	public CalculationBonusConfiguration toDomainWithoutCalculation(CalculationBonusConfigurationEntity entity);

	// Calculation math configuration
	public CalculationMathConfigurationEntity toEntity(CalculationMathConfiguration domain);

	public CalculationMathConfiguration toDomain(CalculationMathConfigurationEntity entity);

	@Named("toCalculationMathWithoutCalculation")
	@Mapping(target = "calculation", ignore = true)
	public CalculationMathConfiguration toDomainWithoutCalculation(CalculationMathConfigurationEntity entity);

	public CalculationMathTypeEntity toEntity(CalculationMathType domain);

	public CalculationMathType toDomain(CalculationMathTypeEntity entity);

	// Calculation transformation configuration
	public CalculationTransformationConfigurationEntity toEntity(CalculationTransformationConfiguration domain);

	public CalculationTransformationConfiguration toDomain(CalculationTransformationConfigurationEntity entity);

	@Named("toCalculationTransformationWithoutCalculation")
	@Mapping(target = "calculation", ignore = true)
	public CalculationTransformationConfiguration toDomainWithoutCalculation(
			CalculationTransformationConfigurationEntity entity);

}