package com.gamifyverse.gamifyapi.attributes.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class AttributeDto {
	private String name;
	private String description;
	private UUID attributeTypeUUID;
	private UUID externalUUID;
	private Boolean active;
}
