package com.gamifyverse.gamifyapi.action.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gamifyverse.gamifyapi.action.model.ScheduleType;

public interface ScheduleTypePersistenceAdapter {

	public List<ScheduleType> getAllScheduleTypes();

	public Optional<ScheduleType> getScheduleTypeByExternalUUID(UUID externalUUID);

}
