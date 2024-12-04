package com.gamifyverse.gamifyapi.trigger.controller.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class TriggerDto {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
	private UUID gameUUID;
	private UUID triggerTypeUUID;
	private UUID triggerEffectTypeUUID;
	private UUID attributeUUID;
	private UUID actionUUID;
	private LocalDateTime creationDate;
	private Boolean active;
}
