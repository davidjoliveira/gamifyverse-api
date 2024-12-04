package com.gamifyverse.gamifyapi.trigger.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.game.model.Game;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trigger {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
	private Game game;
	private TriggerType triggerType;
	private TriggerEffectType triggerEffectType;
	private Action action;
	private Attribute attribute;

	private LocalDateTime creationDate;
	private Boolean active;

	public static Trigger createTrigger(String name, String description, Game game, TriggerType triggerType,
			TriggerEffectType triggerEffectType, Action action, Attribute attribute) {
		if (game == null) {
			throw new RuntimeException("You must provide a game to associate on trigger creation");
		}
		if (triggerEffectType == null) {
			throw new RuntimeException("You must provide a trigger effect to associate on trigger creation");
		}
		if (action == null) {
			throw new RuntimeException("You must provide an action to associate on trigger creation");
		}
		if (TriggerEffectTypeEnum.fromId(triggerEffectType.getId()) == TriggerEffectTypeEnum.ATTRIBUTECHANGE
				&& attribute == null) {
			throw new RuntimeException("You must provide an attribute to associate on trigger creation for type attribute change");
		}
		if (triggerType == null) {
			throw new RuntimeException(String.format("You must provide a trigger type to create a trigger for game %s",
					game.getExternalUUID()));
		}

		return new Trigger(null, name, description, UUID.randomUUID(), game, triggerType, triggerEffectType, action,
				attribute, LocalDateTime.now(), true);
	}

	public boolean hasToCreateConfiguration() {
		return triggerType.hasToCreateConfiguration();
	}

	public boolean hasToCreateAttributeConfiguration() {
		return triggerType.hasToCreateAttributeConfiguration();
	}

	public boolean hasToCreateRateConfiguration() {
		return triggerType.hasToCreateRateConfiguration();
	}
}
