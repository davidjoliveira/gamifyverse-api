package com.gamifyverse.gamifyapi.attributes.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class AttributeTypeDto {
	private String name;
	private String description;
	private UUID externalUUID;
}
