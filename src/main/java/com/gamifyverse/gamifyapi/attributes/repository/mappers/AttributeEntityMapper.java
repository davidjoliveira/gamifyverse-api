package com.gamifyverse.gamifyapi.attributes.repository.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.attributes.model.AttributeType;
import com.gamifyverse.gamifyapi.attributes.model.AttributeTypeEnum;
import com.gamifyverse.gamifyapi.attributes.repository.entity.AttributeEntity;
import com.gamifyverse.gamifyapi.attributes.repository.entity.AttributeTypeEntity;

@Mapper(componentModel = "spring")
public interface AttributeEntityMapper {

	public AttributeType toDomain(AttributeTypeEntity entity);

	public List<AttributeType> toAttributeTypeList(List<AttributeTypeEntity> entity);

	public Attribute toDomain(AttributeEntity entity);

	public AttributeEntity toEntity(Attribute domain);

	public List<Attribute> toAttributeList(List<AttributeEntity> entitites);

	public static Integer map(AttributeTypeEnum enumm) {
		return enumm.getCode();
	}

	public static AttributeTypeEnum map(Integer intt) {
		return AttributeTypeEnum.fromCode(intt);
	}

}
