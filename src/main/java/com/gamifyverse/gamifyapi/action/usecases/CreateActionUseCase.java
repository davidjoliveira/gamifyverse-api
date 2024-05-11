package com.gamifyverse.gamifyapi.action.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.action.adapters.ActionPersistenceAdapter;
import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.service.ActionService;
import com.gamifyverse.gamifyapi.action.usecases.command.CreateActionCommand;

@Component
public class CreateActionUseCase {

	@Autowired
	private ActionService actionService;

	@Autowired
	private ActionPersistenceAdapter actionPersistenceAdapter;

	public Action handle(CreateActionCommand command) {
		Action action = actionService.createActionModel(command);
		return actionPersistenceAdapter.createAction(action);
	}

}
