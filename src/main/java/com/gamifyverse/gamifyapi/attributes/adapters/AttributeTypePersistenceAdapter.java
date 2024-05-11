package com.gamifyverse.gamifyapi.attributes.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gamifyverse.gamifyapi.attributes.model.AttributeType;

public interface AttributeTypePersistenceAdapter {

	public List<AttributeType> getAllAttributeTypes();

	public Optional<AttributeType> getAttributeTypeByUUID(UUID attributeTypeUUID);

}
