package com.gamifyverse.gamifyapi.attributes.usecases.command;

import java.util.UUID;

import com.gamifyverse.gamifyapi.attributes.controller.dto.CreateAttributeDto;

import lombok.Value;

@Value
public class CreateAttributeCommand {
	private String name;
	private String description;
	private UUID attributeTypeUUID;
	private UUID gameUUID;

	public static CreateAttributeCommand from(CreateAttributeDto dto) {
		return new CreateAttributeCommand(dto.getName(), dto.getDescription(), dto.getAttributeTypeUUID(),
				dto.getGameUUID());
	}
}
