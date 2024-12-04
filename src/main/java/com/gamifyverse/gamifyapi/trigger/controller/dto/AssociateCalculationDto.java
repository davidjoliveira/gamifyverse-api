package com.gamifyverse.gamifyapi.trigger.controller.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class AssociateCalculationDto {
	private List<UUID> calculations;
}
