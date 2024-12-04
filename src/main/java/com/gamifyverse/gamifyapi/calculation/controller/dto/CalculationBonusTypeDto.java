package com.gamifyverse.gamifyapi.calculation.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CalculationBonusTypeDto {
	private String name;
	private String description;
	private UUID externalUUID;
}
