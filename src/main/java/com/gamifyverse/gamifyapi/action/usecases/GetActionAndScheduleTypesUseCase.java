package com.gamifyverse.gamifyapi.action.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.action.adapters.ActionPersistenceAdapter;
import com.gamifyverse.gamifyapi.action.adapters.ActionTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.action.adapters.ScheduleTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.model.ActionType;
import com.gamifyverse.gamifyapi.action.model.ScheduleType;
import com.gamifyverse.gamifyapi.action.usecases.command.GetActionTypesCommand;
import com.gamifyverse.gamifyapi.action.usecases.command.GetActionsByGameCommand;
import com.gamifyverse.gamifyapi.action.usecases.command.GetScheduleTypesCommand;

@Component
public class GetActionAndScheduleTypesUseCase {

	@Autowired
	private ActionTypePersistenceAdapter actionTypesPersistence;

	@Autowired
	private ScheduleTypePersistenceAdapter scheduleTypesPersistence;

	@Autowired
	private ActionPersistenceAdapter actionPersistence;

	public List<ActionType> handle(GetActionTypesCommand command) {
		return actionTypesPersistence.getAllActionTypes();
	}

	public List<ScheduleType> handle(GetScheduleTypesCommand command) {
		return scheduleTypesPersistence.getAllScheduleTypes();
	}

	public List<Action> handle(GetActionsByGameCommand command) {
		return actionPersistence.getActionsByGameUUID(command.getGameUUID());
	}

}
