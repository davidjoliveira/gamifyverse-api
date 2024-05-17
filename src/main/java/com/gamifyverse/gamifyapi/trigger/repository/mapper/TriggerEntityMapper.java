package com.gamifyverse.gamifyapi.trigger.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.gamifyverse.gamifyapi.action.repository.entity.ActionEntity;
import com.gamifyverse.gamifyapi.attributes.repository.mappers.AttributeEntityMapper;
import com.gamifyverse.gamifyapi.game.repository.mappers.GameEntityMapper;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerEffectType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionAttributeConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionRateConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerRateType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerType;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerEffectTypeEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionAttributeConfigurationEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionConfigurationEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionRateConfigurationEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerRateTypeEntity;
import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerTypeEntity;

@Mapper(componentModel = "spring", uses = { AttributeEntityMapper.class, GameEntityMapper.class, ActionEntity.class })
public interface TriggerEntityMapper {

	// Trigger types
	public TriggerType toDomain(TriggerTypeEntity entity);

	public List<TriggerType> toTriggerTypeDomainList(List<TriggerTypeEntity> entities);

	// TriggerEffect types
	public TriggerEffectType toDomain(TriggerEffectTypeEntity entity);

	public List<TriggerEffectType> toTriggerEffectDomainList(List<TriggerEffectTypeEntity> entitie);

	// Trigger rate types
	public TriggerRateType toDomain(TriggerRateTypeEntity entity);

	public List<TriggerRateType> toTriggerRateDomainList(List<TriggerRateTypeEntity> entities);

	// trigger
	public TriggerEntity toEntity(Trigger domain);

	public Trigger toDomain(TriggerEntity entity);

	// Trigger execution configuration
	public TriggerExecutionConfigurationEntity toEntity(TriggerExecutionConfiguration domain);

	public TriggerExecutionConfiguration toDomain(TriggerExecutionConfigurationEntity entity);

	// Trigger execution attribute configuration
	public TriggerExecutionAttributeConfigurationEntity toEntity(TriggerExecutionAttributeConfiguration domain);

	public TriggerExecutionAttributeConfiguration toDomain(TriggerExecutionAttributeConfigurationEntity entity);

	// Trigger execution rate configuration
	public TriggerExecutionRateConfigurationEntity toEntity(TriggerExecutionRateConfiguration domain);

	public TriggerExecutionRateConfiguration toDomain(TriggerExecutionRateConfigurationEntity entity);

}
