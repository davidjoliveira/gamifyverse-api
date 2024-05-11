package com.gamifyverse.gamifyapi.action.adapters.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.model.ActionType;
import com.gamifyverse.gamifyapi.action.model.ScheduleType;
import com.gamifyverse.gamifyapi.action.repository.entity.ActionEntity;
import com.gamifyverse.gamifyapi.action.repository.entity.ActionTypeEntity;
import com.gamifyverse.gamifyapi.action.repository.entity.ScheduleTypeEntity;
import com.gamifyverse.gamifyapi.attributes.repository.mappers.AttributeEntityMapper;
import com.gamifyverse.gamifyapi.game.repository.mappers.GameEntityMapper;

@Mapper(componentModel = "spring", uses = { AttributeEntityMapper.class, GameEntityMapper.class })
public interface ActionEntityMapper {

	public ActionType toDomain(ActionTypeEntity entity);

	public List<ActionType> toActionTypeList(List<ActionTypeEntity> entity);

	public ScheduleType toDomain(ScheduleTypeEntity entity);

	public List<ScheduleType> toScheduleTypeList(List<ScheduleTypeEntity> entity);

	public ActionEntity toEntity(Action action);

	public Action toDomain(ActionEntity entity);

	public List<Action> toActionDomainList(List<ActionEntity> entities);

}
