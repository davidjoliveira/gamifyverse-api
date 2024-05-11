package com.gamifyverse.gamifyapi.attributes.controller.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gamifyverse.gamifyapi.attributes.controller.dto.AttributeDto;
import com.gamifyverse.gamifyapi.attributes.controller.dto.AttributeTypeDto;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.attributes.model.AttributeType;

@Mapper(componentModel = "spring")
public interface AttributeDtoMapper {

	@Mapping(source = "game.externalUUID", target = "gameUUID")
	@Mapping(source = "attributeType.externalUUID", target = "attributeTypeUUID")
	public AttributeDto tODto(Attribute domain);
	
	public AttributeTypeDto toDto(AttributeType domain);

	public List<AttributeTypeDto> toAttributeTypeDtoList(List<AttributeType> domain);

	public List<AttributeDto> toAttributeDtoList(List<Attribute> result);

}
