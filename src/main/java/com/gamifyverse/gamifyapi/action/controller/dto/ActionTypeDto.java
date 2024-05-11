package com.gamifyverse.gamifyapi.action.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ActionTypeDto {
	private String name;
	private String description;
	private UUID externalUUID;
}
