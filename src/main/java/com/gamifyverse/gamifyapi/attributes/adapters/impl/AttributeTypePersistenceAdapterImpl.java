package com.gamifyverse.gamifyapi.attributes.adapters.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.attributes.adapters.AttributePersistenceAdapter;
import com.gamifyverse.gamifyapi.attributes.adapters.AttributeTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.attributes.model.AttributeType;
import com.gamifyverse.gamifyapi.attributes.repository.AttributeRepository;
import com.gamifyverse.gamifyapi.attributes.repository.AttributeTypeRepository;
import com.gamifyverse.gamifyapi.attributes.repository.entity.AttributeEntity;
import com.gamifyverse.gamifyapi.attributes.repository.entity.AttributeTypeEntity;
import com.gamifyverse.gamifyapi.attributes.repository.mappers.AttributeEntityMapper;

@Component
public class AttributeTypePersistenceAdapterImpl
		implements AttributeTypePersistenceAdapter, AttributePersistenceAdapter {

	@Autowired
	private AttributeTypeRepository attributeTypeRepository;

	@Autowired
	private AttributeRepository attributeRepository;

	@Autowired
	private AttributeEntityMapper mapper;

	@Override
	public List<AttributeType> getAllAttributeTypes() {
		List<AttributeTypeEntity> entities = attributeTypeRepository.findAll();
		return mapper.toAttributeTypeList(entities);
	}

	@Override
	public List<Attribute> getAttributesByGameUUID(UUID gameUUID) {
		List<AttributeEntity> entities = attributeRepository.getByGameExternalUUIDAndActive(gameUUID, true);
		return mapper.toAttributeList(entities);
	}

	@Override
	public Attribute persistAttribute(Attribute attribute) {
		AttributeEntity entity = mapper.toEntity(attribute);
		return mapper.toDomain(attributeRepository.save(entity));
	}

	@Override
	public Optional<AttributeType> getAttributeTypeByUUID(UUID attributeTypeUUID) {
		Optional<AttributeTypeEntity> entity = attributeTypeRepository.findByExternalUUID(attributeTypeUUID);
		return entity.map(mapper::toDomain);
	}

	@Override
	public Optional<Attribute> getAttributeByExternalUUID(UUID externalUUID) {
		Optional<AttributeEntity> attrEntity = attributeRepository.findByExternalUUID(externalUUID);
		return attrEntity.map(mapper::toDomain);
	}

}
