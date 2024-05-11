package com.gamifyverse.gamifyapi.action.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.game.model.Game;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Action {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
	private Game game;
	private ActionType actionType;
	private ScheduleType scheduleType;
	private String schedule;
	private Attribute attribute;
	private LocalDateTime creationDate;
	private Boolean active;

	public static Action createNewAction(String name, String description, Long actionTypeId, Long scheduleTypeId,
			String schedule, Long attributeId, Long gameId) {
		Game game = new Game(gameId, null, null, null, null);
		ActionType actionType = new ActionType(actionTypeId, null, null, null);
		Attribute attribute = new Attribute(attributeId, game, null, null, null, null, null);
		ScheduleType scheduleType = null;
		if (scheduleTypeId != null) {
			scheduleType = new ScheduleType(scheduleTypeId, null, null, null);
		}
		return createNewAction(name, description, actionType, scheduleType, schedule, attribute, game);
	}

	public static Action createNewAction(String name, String description, ActionType actionType,
			ScheduleType scheduleType, String schedule, Attribute attribute, Game game) {
		if (actionType == null || actionType.getId() == null) {
			throw new RuntimeException(String.format("You must inform a valid action type to create an action"));
		}
		if (attribute == null || attribute.getId() == null) {
			throw new RuntimeException(String.format("You must inform a valid attribute to create an action"));
		}
		if (game == null || game.getId() == null) {
			throw new RuntimeException(String.format("You must inform a valid game to create an action"));
		}
		ActionTypeEnum actionTypeEnum = ActionTypeEnum.fromId(actionType.getId());
		if (actionTypeEnum == ActionTypeEnum.SCHEDULED_ACTION) {
			if (scheduleType == null) {
				throw new RuntimeException(
						String.format("You must inform a valid schedule type to create an action if type SCHEDULED"));
			}
			if (schedule == null || schedule.isBlank()) {
				throw new RuntimeException(
						String.format("You must inform a valid schedule to create an action if type SCHEDULED"));
			}
		} else {
			schedule = null;
			scheduleType = null;
		}
		Action action = new Action(null, name, description, UUID.randomUUID(), game, actionType, scheduleType, schedule,
				attribute, LocalDateTime.now(), true);
		return action;
	}

}
