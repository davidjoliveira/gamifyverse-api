package com.gamifyverse.gamifyapi.trigger.service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.service.ActionService;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.attributes.service.AttributeService;
import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.service.GameService;
import com.gamifyverse.gamifyapi.trigger.adapters.TriggerTypeValuesPersistenceAdapter;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerEffectType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionAttributeConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionRateConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerRateType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerType;
import com.gamifyverse.gamifyapi.trigger.usecases.command.CreateTriggerCommand;

@Service
public class TriggerService {

	@Autowired
	private ActionService actionService;

	@Autowired
	private GameService gameService;

	@Autowired
	private AttributeService attributeService;

	@Autowired
	private TriggerTypeValuesPersistenceAdapter triggerTypeValuesPersistenceAdapter;

	@Async
	public CompletableFuture<TriggerType> findTriggerType(UUID actionUUID) {
		Optional<TriggerType> action = triggerTypeValuesPersistenceAdapter.findTriggerTypeByUUID(actionUUID);
		return CompletableFuture.<TriggerType>completedFuture(action.orElse(null));
	}

	@Async
	public CompletableFuture<TriggerEffectType> findTriggerEffectType(UUID actionUUID) {
		Optional<TriggerEffectType> action = triggerTypeValuesPersistenceAdapter.findTriggerEffectByUUID(actionUUID);
		return CompletableFuture.<TriggerEffectType>completedFuture(action.orElse(null));
	}

	@Async
	public CompletableFuture<TriggerRateType> findTriggerRateType(UUID actionUUID) {
		Optional<TriggerRateType> action = triggerTypeValuesPersistenceAdapter.findTriggerRateByUUID(actionUUID);
		return CompletableFuture.<TriggerRateType>completedFuture(action.orElse(null));
	}

	public TriggerExecutionConfiguration createTriggerConfiguration(Trigger trigger, CreateTriggerCommand command) {
		return TriggerExecutionConfiguration.createExecutionConfiguration(trigger, command.getExecutionTImes());
	}

	public TriggerExecutionAttributeConfiguration createTriggerAttributeConfiguration(Trigger trigger,
			CreateTriggerCommand command) {
		CompletableFuture<Attribute> attributeFuture = attributeService.findAttribute(command.getAttributeUUID());
		try {
			return attributeFuture.thenApply(v -> {
				return TriggerExecutionAttributeConfiguration.createAttributeConfiguration(trigger, v,
						command.getAttributeValue());
			}).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(String.format(
					"It was not possible to create a proper trigger attribute configuration due to error %s",
					e.getMessage()), e);
		}
	}

	public TriggerExecutionRateConfiguration createTriggerRateConfguration(Trigger trigger,
			CreateTriggerCommand command) {
		CompletableFuture<TriggerRateType> rateFuture = this.findTriggerRateType(command.getTriggerRateTypeUUID());
		try {
			return rateFuture.thenApply(v -> {
				return TriggerExecutionRateConfiguration.createRateConfiguration(trigger, v, command.getBaseRate(),
						command.getIncrementRate());
			}).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(
					String.format("It was not possible to create a proper trigger rate configuration due to error %s",
							e.getMessage()),
					e);
		}
	}

	public Trigger createTrigger(CreateTriggerCommand command) {
		CompletableFuture<Game> gameFuture = gameService.findGame(command.getGameUUID());
		CompletableFuture<Action> actionFuture = actionService.findAction(command.getActionUUID());
		CompletableFuture<TriggerType> triggerTypeFuture = this.findTriggerType(command.getTriggerTypeUUID());
		CompletableFuture<TriggerEffectType> triggerEffectFuture = this
				.findTriggerEffectType(command.getTriggerEffectTypeUUID());

		try {
			return CompletableFuture.allOf(gameFuture, actionFuture, triggerTypeFuture, triggerEffectFuture)
					.thenApply(v -> {
						return Trigger.createTrigger(command.getName(), command.getDescription(), gameFuture.join(),
								triggerTypeFuture.join(), triggerEffectFuture.join(), actionFuture.join());
					}).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(
					String.format("It was not possible to create a proper trigger due to error %s", e.getMessage()), e);
		}
	}

}
