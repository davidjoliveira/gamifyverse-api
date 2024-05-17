package com.gamifyverse.gamifyapi.action.service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.action.adapters.ActionPersistenceAdapter;
import com.gamifyverse.gamifyapi.action.adapters.ActionTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.action.adapters.ScheduleTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.model.ActionType;
import com.gamifyverse.gamifyapi.action.model.ScheduleType;
import com.gamifyverse.gamifyapi.action.usecases.command.CreateActionCommand;
import com.gamifyverse.gamifyapi.attributes.adapters.AttributePersistenceAdapter;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.service.GameService;

@Service
public class ActionService {

	@Autowired
	private AttributePersistenceAdapter attributePersistenceAdapter;

	@Autowired
	private ActionTypePersistenceAdapter actionTypePersistenceAdapter;

	@Autowired
	private ScheduleTypePersistenceAdapter scheduleTypePersistenceAdapter;

	@Autowired
	private ActionPersistenceAdapter actionAdapter;

	@Autowired
	private GameService gameService;

	@Async
	private CompletableFuture<Attribute> findAttribute(UUID attributeUUID) {
		Optional<Attribute> optAttribute = attributePersistenceAdapter.getAttributeByExternalUUID(attributeUUID);
		return CompletableFuture.<Attribute>completedFuture(optAttribute.orElse(null));
	}

	@Async
	private CompletableFuture<ActionType> findActionType(UUID actionTypeUUID) {
		Optional<ActionType> optActionType = actionTypePersistenceAdapter.getByExternalUUID(actionTypeUUID);
		return CompletableFuture.<ActionType>completedFuture(optActionType.orElse(null));
	}

	@Async
	private CompletableFuture<ScheduleType> findScheduleType(UUID scheduleTypeUUID) {
		if (scheduleTypeUUID == null)
			return CompletableFuture.<ScheduleType>completedFuture(null);

		Optional<ScheduleType> optScheduleType = scheduleTypePersistenceAdapter
				.getScheduleTypeByExternalUUID(scheduleTypeUUID);
		return CompletableFuture.<ScheduleType>completedFuture(optScheduleType.orElse(null));
	}

	@Async
	public CompletableFuture<Action> findAction(UUID actionUUID) {
		Optional<Action> optAction = actionAdapter.getActionByUUID(actionUUID);
		return CompletableFuture.<Action>completedFuture(optAction.orElse(null));
	}

	public Action createActionModel(CreateActionCommand command) {
		CompletableFuture<Attribute> attributeFuture = findAttribute(command.getAttributeUUID());
		CompletableFuture<ActionType> actionTypeFuture = findActionType(command.getActionTypeUUID());
		CompletableFuture<Game> gameFuture = gameService.findGame(command.getGameUUID());
		CompletableFuture<ScheduleType> scheduleTypeFuture = findScheduleType(command.getScheduleTypeUUID());
		try {
			return CompletableFuture.allOf(attributeFuture, actionTypeFuture, gameFuture, scheduleTypeFuture)
					.thenApply(v -> {
						return Action.createNewAction(command.getName(), command.getDescription(),
								actionTypeFuture.join(), scheduleTypeFuture.join(), command.getSchedule(),
								attributeFuture.join(), gameFuture.join());
					}).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(
					String.format("It was not possible to create a proper action due to error %s", e.getMessage()), e);
		}
	}

}
