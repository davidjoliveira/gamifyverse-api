package com.gamifyverse.gamifyapi.action.usecases.command;

import java.util.UUID;

import com.gamifyverse.gamifyapi.action.controller.dto.CreateActionDto;

import lombok.Value;

@Value
public class CreateActionCommand {
	private String name;
	private String description;
	private UUID attributeUUID;
	private UUID actionTypeUUID;
	private UUID scheduleTypeUUID;
	private String schedule;
	private UUID gameUUID;

	public static CreateActionCommand from(CreateActionDto dto) {
		return new CreateActionCommand(dto.getName(), dto.getDescription(), dto.getAttributeUUID(),
				dto.getActionTypeUUID(), dto.getScheduleTypeUUID(), dto.getSchedule(), dto.getGameUUID());
	}
}
