package com.gamifyverse.gamifyapi.calculation.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationTransformationType {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
}
