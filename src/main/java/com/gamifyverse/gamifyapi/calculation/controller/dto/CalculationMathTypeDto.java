package com.gamifyverse.gamifyapi.calculation.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CalculationMathTypeDto {
	private String name;
	private String description;
	private UUID externalUUID;
}
