package com.gamifyverse.gamifyapi.calculation.adapters.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.calculation.adapters.CalculationPersistenceAdapter;
import com.gamifyverse.gamifyapi.calculation.adapters.CalculationTypesValuesPersistenceAdapter;
import com.gamifyverse.gamifyapi.calculation.model.Calculation;
import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationOriginValueType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationConfiguration;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationType;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationBonusConfigurationRepository;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationBonusTypeRepository;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationMathConfigurationRepository;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationMathTypeRepository;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationOriginValueTypeRepository;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationRepository;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationTransformationConfigurationRepository;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationTransformationTypeRepository;
import com.gamifyverse.gamifyapi.calculation.repository.CalculationTypeRepository;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationBonusConfigurationEntity;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationBonusTypeEntity;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationEntity;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationMathConfigurationEntity;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationMathTypeEntity;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationOriginValueTypeEntity;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationTransformationConfigurationEntity;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationTransformationTypeEntity;
import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationTypeEntity;
import com.gamifyverse.gamifyapi.calculation.repository.mapper.CalculationEntityMapper;

@Component
public class CalculationPersistenceAdapterImpl
		implements CalculationPersistenceAdapter, CalculationTypesValuesPersistenceAdapter {

	@Autowired
	private CalculationTypeRepository calculationTypeRepository;

	@Autowired
	private CalculationMathTypeRepository calculationMathTypeRepository;

	@Autowired
	private CalculationTransformationTypeRepository calculationTransformationTypeRepository;

	@Autowired
	private CalculationBonusTypeRepository calculationBonusTypeRepository;

	@Autowired
	private CalculationOriginValueTypeRepository calculationOriginValueTypeRepository;

	@Autowired
	private CalculationRepository calculationRepository;

	@Autowired
	private CalculationMathConfigurationRepository calculationMathConfigurationRepository;

	@Autowired
	private CalculationTransformationConfigurationRepository calculationTransformationConfigurationRepository;

	@Autowired
	private CalculationBonusConfigurationRepository bonusConfigurationRepository;

	@Autowired
	private CalculationEntityMapper mapper;

	@Override
	public Optional<CalculationType> findCalculationTypeByUUID(UUID calculationTypeUUID) {
		Optional<CalculationTypeEntity> opt = calculationTypeRepository.findByExternalUUID(calculationTypeUUID);
		return opt.map(mapper::toDomain);
	}

	@Override
	public Optional<CalculationMathType> findCalculationMathTypeByUUID(UUID calculationMathTypeUUID) {
		Optional<CalculationMathTypeEntity> opt = calculationMathTypeRepository
				.findByExternalUUID(calculationMathTypeUUID);
		return opt.map(mapper::toDomain);
	}

	@Override
	public Optional<CalculationTransformationType> findCalculationTransformationTypeByUUID(
			UUID calculationTransformationType) {
		Optional<CalculationTransformationTypeEntity> opt = calculationTransformationTypeRepository
				.findByExternalUUID(calculationTransformationType);
		return opt.map(mapper::toDomain);
	}

	@Override
	public Optional<CalculationBonusType> findCalculationBonusTypeByUUID(UUID calculationBonusTypeUUID) {
		Optional<CalculationBonusTypeEntity> opt = calculationBonusTypeRepository
				.findByExternalUUID(calculationBonusTypeUUID);
		return opt.map(mapper::toDomain);
	}

	@Override
	public Optional<CalculationOriginValueType> findCalculationOriginValueTypeByUUID(
			UUID calculationOriginValueTypeUUID) {
		Optional<CalculationOriginValueTypeEntity> opt = calculationOriginValueTypeRepository
				.findByExternalUUID(calculationOriginValueTypeUUID);
		return opt.map(mapper::toDomain);
	}

	@Override
	public Calculation persistCalculation(Calculation calculation) {
		CalculationEntity entity = mapper.toEntity(calculation);
		return mapper.toDomain(calculationRepository.save(entity));
	}

	@Override
	public CalculationMathConfiguration persistCalculationMathConfiguration(CalculationMathConfiguration mathConfig) {
		CalculationMathConfigurationEntity entity = mapper.toEntity(mathConfig);
		return mapper.toDomain(calculationMathConfigurationRepository.save(entity));
	}

	@Override
	public CalculationTransformationConfiguration persistCalculationTransformationConfiguration(
			CalculationTransformationConfiguration transformationConfig) {
		CalculationTransformationConfigurationEntity entity = mapper.toEntity(transformationConfig);
		return mapper.toDomain(calculationTransformationConfigurationRepository.save(entity));
	}

	@Override
	public CalculationBonusConfiguration persistCalculationBonusConfiguration(
			CalculationBonusConfiguration bonusConfig) {
		CalculationBonusConfigurationEntity entity = mapper.toEntity(bonusConfig);
		return mapper.toDomain(bonusConfigurationRepository.save(entity));
	}

	@Override
	public List<CalculationType> findAllCalculationTypes() {
		return calculationTypeRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public List<CalculationMathType> findAllCalculationMathTypes() {
		return calculationMathTypeRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public List<CalculationTransformationType> findAllCalculationTransformationTypes() {
		return calculationTransformationTypeRepository.findAll().stream().map(mapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<CalculationBonusType> findAllCalculationBonusTypes() {
		return calculationBonusTypeRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public List<Calculation> getCalculationsByGameUUID(UUID gameUUID) {
		return calculationRepository.findByGameExternalUUID(gameUUID).stream().map(mapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Calculation> getCalculationByExternalUUID(UUID calculationUUID) {
		return calculationRepository.findByExternalUUID(calculationUUID).map(mapper::toDomain);
	}

}
