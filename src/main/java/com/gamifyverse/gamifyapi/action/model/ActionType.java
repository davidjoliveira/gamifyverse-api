package com.gamifyverse.gamifyapi.action.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionType {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
}
