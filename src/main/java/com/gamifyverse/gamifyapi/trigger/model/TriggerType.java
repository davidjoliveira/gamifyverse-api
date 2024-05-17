package com.gamifyverse.gamifyapi.trigger.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TriggerType {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;

	public boolean hasToCreateConfiguration() {
		TriggerTypeEnum enumm = TriggerTypeEnum.fromId(id);
		return enumm == TriggerTypeEnum.EXECUTENTIMES;
	}

	public boolean hasToCreateAttributeConfiguration() {
		TriggerTypeEnum enumm = TriggerTypeEnum.fromId(id);
		return enumm == TriggerTypeEnum.EXECUTEATTRIBUTEVALUEEQ || enumm == TriggerTypeEnum.EXECUTEATTRIBUTEVALUEGT
				|| enumm == TriggerTypeEnum.EXECUTEATTRIBUTEVALUELT;
	}

	public boolean hasToCreateRateConfiguration() {
		TriggerTypeEnum enumm = TriggerTypeEnum.fromId(id);
		return enumm == TriggerTypeEnum.EXECUTERANDOM;
	}
}
