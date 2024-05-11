package com.gamifyverse.gamifyapi.action.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gamifyverse.gamifyapi.action.model.ActionType;

public interface ActionTypePersistenceAdapter {

	public List<ActionType> getAllActionTypes();

	public Optional<ActionType> getByExternalUUID(UUID externalUUID);

}
