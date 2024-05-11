package com.gamifyverse.gamifyapi.action.controller.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateActionDto {

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String name;
	private String description;

	@NotNull
	private UUID attributeUUID;
	@NotNull
	private UUID actionTypeUUID;

	private UUID scheduleTypeUUID;
	private String schedule;

	@NotNull
	private UUID gameUUID;

}
