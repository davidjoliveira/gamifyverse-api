package com.gamifyverse.gamifyapi.action.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ActionDto {
	private String name;
	private String description;
	private UUID actionTypeUUID;
	private UUID scheduleTypeUUID;
	private UUID attributeUUID;
	private UUID externalUUID;
	private UUID gameUUID;
	private Boolean active;
}
