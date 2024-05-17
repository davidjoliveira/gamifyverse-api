package com.gamifyverse.gamifyapi.trigger.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TriggerEffectType {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
}
