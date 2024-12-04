package com.gamifyverse.gamifyapi.calculation.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gamifyverse.gamifyapi.calculation.model.*;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationBonusTypeDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationMathTypeDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationTransformationTypeDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationTypeDto;

@Mapper(componentModel = "spring")
public interface CalculationDtoMapper {

	// Calculation types
	public CalculationTypeDto toDto(CalculationType domain);

	public List<CalculationTypeDto> toCalculationTypeDtoList(List<CalculationType> domains);

//    // Calculation origin value types
//    public CalculationOriginValueTypeDto toDto(CalculationOriginValueType domain);
//
//    public List<CalculationOriginValueTypeDto> toCalculationOriginValueTypeDtoList(List<CalculationOriginValueType> domains);
//
//    // Calculation transformation types
	public CalculationTransformationTypeDto toDto(CalculationTransformationType domain);

	public List<CalculationTransformationTypeDto> toCalculationTransformationTypeDtoList(
			List<CalculationTransformationType> domains);

//
//    // Calculation bonus types
	public CalculationBonusTypeDto toDto(CalculationBonusType domain);

	public List<CalculationBonusTypeDto> toCalculationBonusTypeDtoList(List<CalculationBonusType> domains);

//  // Calculation math types
	public CalculationMathTypeDto toDto(CalculationMathType domain);

	public List<CalculationMathTypeDto> toCalculationMathTypeDtoList(List<CalculationMathType> domains);

//
//    // Calculation
	@Mapping(source = "game.externalUUID", target = "gameUUID")
	@Mapping(source = "calculationType.externalUUID", target = "calculationTypeUUID")
	@Mapping(source = "calculationMath.calculationMathType.externalUUID", target = "calculationMathTypeUUID")
	@Mapping(source = "calculationMath.baseValue", target = "baseValue")
	@Mapping(source = "calculationTransformation.calculationTransformationType.externalUUID", target = "calculationTransformationTypeUUID")
	@Mapping(source = "calculationBonus.calculationBonusType.externalUUID", target = "calculationBonusTypeUUID")
	@Mapping(source = "calculationBonus.bonusBaseVaue", target = "baseBonusValue")
	@Mapping(source = "calculationBonus.bonusUpperValue", target = "upperBonusValue")
	public CalculationDto toDto(Calculation domain);

	public List<CalculationDto> toCalculationDtoList(List<Calculation> domain);

//	public Calculation toDomain(CalculationDto dto);
//
//    // Calculation bonus configuration
//    public CalculationBonusConfigurationDto toDto(CalculationBonusConfiguration domain);
//
//    public CalculationBonusConfiguration toDomain(CalculationBonusConfigurationDto dto);
//
//    // Calculation math configuration
//    public CalculationMathConfigurationDto toDto(CalculationMathConfiguration domain);
//
//    public CalculationMathConfiguration toDomain(CalculationMathConfigurationDto dto);
//
//    // Calculation transformation configuration
//    public CalculationTransformationConfigurationDto toDto(CalculationTransformationConfiguration domain);
//
//    public CalculationTransformationConfiguration toDomain(CalculationTransformationConfigurationDto dto);

}