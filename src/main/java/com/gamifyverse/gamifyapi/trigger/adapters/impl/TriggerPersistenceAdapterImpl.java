package com.gamifyverse.gamifyapi.trigger.adapters.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.trigger.adapters.TriggerPersistenceAdapter;
import com.gamifyverse.gamifyapi.trigger.adapters.TriggerTypeValuesPersistenceAdapter;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerEffectType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionAttributeConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionRateConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerRateType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerType;
import com.gamifyverse.gamifyapi.trigger.repository.TriggerEffectTypeRepository;
import com.gamifyverse.gamifyapi.trigger.repository.TriggerExecutionAttributeConfigurationRepository;
import com.gamifyverse.gamifyapi.trigger.repository.TriggerExecutionConfigurationRepository;
import com.gamifyverse.gamifyapi.trigger.repository.TriggerExecutionRateConfigurationRepository;
import com.gamifyverse.gamifyapi.trigger.repository.TriggerRateTypeRepository;
import com.gamifyverse.gamifyapi.trigger.repository.TriggerRepository;
import com.gamifyverse.gamifyapi.trigger.repository.TriggerTypeRepository;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerEffectTypeEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionAttributeConfigurationEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionConfigurationEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionRateConfigurationEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerRateTypeEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerTypeEntity;
import com.gamifyverse.gamifyapi.trigger.repository.mapper.TriggerEntityMapper;

@Component
public class TriggerPersistenceAdapterImpl implements TriggerTypeValuesPersistenceAdapter, TriggerPersistenceAdapter {

	@Autowired
	private TriggerTypeRepository triggerTypeRepository;

	@Autowired
	private TriggerEffectTypeRepository triggerEffectTypeRepository;

	@Autowired
	private TriggerRateTypeRepository triggerRateTypeRepository;

	@Autowired
	private TriggerRepository triggerRepository;

	@Autowired
	private TriggerExecutionConfigurationRepository executionConfigurationRepository;

	@Autowired
	private TriggerExecutionAttributeConfigurationRepository executionAttributeConfiguration;

	@Autowired
	private TriggerExecutionRateConfigurationRepository executionRateConfiguration;
	
	@Autowired
	private TriggerEntityMapper triggerMpper;

	@Override
	public List<TriggerType> getAllTriggerTypes() {
		List<TriggerTypeEntity> entities = triggerTypeRepository.findAll();
		return triggerMpper.toTriggerTypeDomainList(entities);
	}

	@Override
	public List<TriggerEffectType> getAllTriggerEffectTypes() {
		List<TriggerEffectTypeEntity> entities = triggerEffectTypeRepository.findAll();
		return triggerMpper.toTriggerEffectDomainList(entities);
	}

	@Override
	public List<TriggerRateType> getAllTriggerRateTypes() {
		List<TriggerRateTypeEntity> entities = triggerRateTypeRepository.findAll();
		return triggerMpper.toTriggerRateDomainList(entities);
	}

	@Override
	public Optional<TriggerType> findTriggerTypeByUUID(UUID triggerTypeUUID) {
		Optional<TriggerTypeEntity> optEntity = triggerTypeRepository.findByExternalUUID(triggerTypeUUID);
		return optEntity.map(triggerMpper::toDomain);
	}

	@Override
	public Optional<TriggerEffectType> findTriggerEffectByUUID(UUID triggerEffectUUID) {
		Optional<TriggerEffectTypeEntity> optEntity = triggerEffectTypeRepository.findByExternalUUID(triggerEffectUUID);
		return optEntity.map(triggerMpper::toDomain);
	}

	@Override
	public Optional<TriggerRateType> findTriggerRateByUUID(UUID triggerRateUUID) {
		Optional<TriggerRateTypeEntity> optEntity = triggerRateTypeRepository.findByExternalUUID(triggerRateUUID);
		return optEntity.map(triggerMpper::toDomain);
	}

	@Override
	public Trigger persistTrigger(Trigger trigger) {
		TriggerEntity entity = triggerMpper.toEntity(trigger);
		return triggerMpper.toDomain(triggerRepository.save(entity));
	}

	@Override
	public TriggerExecutionConfiguration persistConfiguration(TriggerExecutionConfiguration config) {
		TriggerExecutionConfigurationEntity entity = triggerMpper.toEntity(config);
		return triggerMpper.toDomain(executionConfigurationRepository.save(entity));
	}

	@Override
	public TriggerExecutionAttributeConfiguration persistConfiguration(TriggerExecutionAttributeConfiguration config) {
		TriggerExecutionAttributeConfigurationEntity entity = triggerMpper.toEntity(config);
		return triggerMpper.toDomain(executionAttributeConfiguration.save(entity));
	}

	@Override
	public TriggerExecutionRateConfiguration persistConfiguration(TriggerExecutionRateConfiguration config) {
		TriggerExecutionRateConfigurationEntity entity = triggerMpper.toEntity(config);
		return triggerMpper.toDomain(executionRateConfiguration.save(entity));
	}

}
