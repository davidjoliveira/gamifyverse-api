package com.gamifyverse.gamifyapi.attributes.adapters;

import java.util.List;
import java.util.UUID;

import com.gamifyverse.gamifyapi.attributes.model.Attribute;

public interface AttributePersistenceAdapter {
	public List<Attribute> getAttributesByGameUUID(UUID gameUUID);
}
