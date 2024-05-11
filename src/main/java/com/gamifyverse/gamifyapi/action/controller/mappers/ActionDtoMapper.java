package com.gamifyverse.gamifyapi.action.controller.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gamifyverse.gamifyapi.action.controller.dto.ActionDto;
import com.gamifyverse.gamifyapi.action.controller.dto.ActionTypeDto;
import com.gamifyverse.gamifyapi.action.controller.dto.ScheduleTypeDto;
import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.model.ActionType;
import com.gamifyverse.gamifyapi.action.model.ScheduleType;

@Mapper(componentModel = "spring")
public interface ActionDtoMapper {

	public ActionTypeDto toDto(ActionType domain);

	public List<ActionTypeDto> toActionTypeDtoList(List<ActionType> domain);

	public ScheduleTypeDto toDto(ScheduleType domain);

	public List<ScheduleTypeDto> toScheduleTypeDtoList(List<ScheduleType> domain);

	@Mapping(source = "game.externalUUID", target = "gameUUID")
	@Mapping(source = "actionType.externalUUID", target = "actionTypeUUID")
	@Mapping(source = "scheduleType.externalUUID", target = "scheduleTypeUUID")
	@Mapping(source = "attribute.externalUUID", target = "attributeUUID")
	public ActionDto toDto(Action action);

	public List<ActionDto> toActionDtoList(List<Action> result);

}
