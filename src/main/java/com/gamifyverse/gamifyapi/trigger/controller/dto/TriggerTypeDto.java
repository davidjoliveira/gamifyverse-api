package com.gamifyverse.gamifyapi.trigger.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class TriggerTypeDto {
	private String name;
	private String description;
	private UUID externalUUID;
}
