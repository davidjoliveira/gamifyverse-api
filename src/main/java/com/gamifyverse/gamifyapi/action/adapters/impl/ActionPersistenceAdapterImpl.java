package com.gamifyverse.gamifyapi.action.adapters.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.action.adapters.ActionPersistenceAdapter;
import com.gamifyverse.gamifyapi.action.adapters.ActionTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.action.adapters.ScheduleTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.action.adapters.mappers.ActionEntityMapper;
import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.model.ActionType;
import com.gamifyverse.gamifyapi.action.model.ScheduleType;
import com.gamifyverse.gamifyapi.action.repository.ActionRepository;
import com.gamifyverse.gamifyapi.action.repository.ActionTypeRepository;
import com.gamifyverse.gamifyapi.action.repository.ScheduleTypeRepository;
import com.gamifyverse.gamifyapi.action.repository.entity.ActionEntity;
import com.gamifyverse.gamifyapi.action.repository.entity.ActionTypeEntity;
import com.gamifyverse.gamifyapi.action.repository.entity.ScheduleTypeEntity;

@Component
public class ActionPersistenceAdapterImpl
		implements ActionTypePersistenceAdapter, ScheduleTypePersistenceAdapter, ActionPersistenceAdapter {

	@Autowired
	private ActionTypeRepository actionTypeRepository;

	@Autowired
	private ScheduleTypeRepository scheduleTypeRepository;

	@Autowired
	private ActionRepository actionRepository;

	@Autowired
	private ActionEntityMapper actionMapper;

	@Override
	public List<ScheduleType> getAllScheduleTypes() {
		return actionMapper.toScheduleTypeList(scheduleTypeRepository.findAll());
	}

	@Override
	public List<ActionType> getAllActionTypes() {
		return actionMapper.toActionTypeList(actionTypeRepository.findAll());
	}

	@Override
	public Optional<ActionType> getByExternalUUID(UUID externalUUID) {
		Optional<ActionTypeEntity> actionTypEntity = actionTypeRepository.findByExternalUUID(externalUUID);
		return actionTypEntity.map(actionMapper::toDomain);
	}

	@Override
	public Optional<ScheduleType> getScheduleTypeByExternalUUID(UUID externalUUID) {
		Optional<ScheduleTypeEntity> scheduleTypeEntity = scheduleTypeRepository.findByExternalUUID(externalUUID);
		return scheduleTypeEntity.map(actionMapper::toDomain);
	}

	@Override
	public Action createAction(Action action) {
		ActionEntity actionEntity = actionMapper.toEntity(action);
		return actionMapper.toDomain(actionRepository.save(actionEntity));
	}

	@Override
	public List<Action> getActionsByGameUUID(UUID gameUUID) {
		List<ActionEntity> entities = actionRepository.findByGameExternalUUIDAndActive(gameUUID, true);
		return actionMapper.toActionDomainList(entities);
	}

}
