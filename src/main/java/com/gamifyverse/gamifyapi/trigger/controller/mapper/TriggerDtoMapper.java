package com.gamifyverse.gamifyapi.trigger.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gamifyverse.gamifyapi.trigger.controller.dto.TriggerDto;
import com.gamifyverse.gamifyapi.trigger.controller.dto.TriggerEffectTypeDto;
import com.gamifyverse.gamifyapi.trigger.controller.dto.TriggerRateTypeDto;
import com.gamifyverse.gamifyapi.trigger.controller.dto.TriggerTypeDto;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerEffectType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerRateType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerType;

@Mapper(componentModel = "spring")
public interface TriggerDtoMapper {
	public TriggerTypeDto toDto(TriggerType domain);

	public List<TriggerTypeDto> toTriggerTypeDtoList(List<TriggerType> domains);

	public TriggerEffectTypeDto toDto(TriggerEffectType domain);

	public List<TriggerEffectTypeDto> toTriggerEffectDtoList(List<TriggerEffectType> domains);

	public TriggerRateTypeDto toDto(TriggerRateType domain);

	public List<TriggerRateTypeDto> toTriggerRateDtoList(List<TriggerRateType> domains);

	@Mapping(source = "game.externalUUID", target = "gameUUID")
	@Mapping(source = "triggerType.externalUUID", target = "triggerTypeUUID")
	@Mapping(source = "triggerEffect.externalUUID", target = "triggerEffectTypeUUID")
	@Mapping(source = "action.externalUUID", target = "actionUUID")
	public TriggerDto toDto(Trigger domain);
}
