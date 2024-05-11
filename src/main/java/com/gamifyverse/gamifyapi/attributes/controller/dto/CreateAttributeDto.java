package com.gamifyverse.gamifyapi.attributes.controller.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAttributeDto {
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String name;
	private String description;

	@NotNull
	private UUID attributeTypeUUID;

	@NotNull
	private UUID gameUUID;
}
