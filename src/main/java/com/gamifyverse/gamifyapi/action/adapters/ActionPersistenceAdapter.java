package com.gamifyverse.gamifyapi.action.adapters;

import java.util.List;
import java.util.UUID;

import com.gamifyverse.gamifyapi.action.model.Action;

public interface ActionPersistenceAdapter {
	public Action createAction(Action action);

	public List<Action> getActionsByGameUUID(UUID gameUUID);
}
