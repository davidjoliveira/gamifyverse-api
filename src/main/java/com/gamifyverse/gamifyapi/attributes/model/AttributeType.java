package com.gamifyverse.gamifyapi.attributes.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttributeType {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
}
