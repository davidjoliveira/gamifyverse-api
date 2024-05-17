package com.gamifyverse.gamifyapi.trigger.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.trigger.adapters.TriggerPersistenceAdapter;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionAttributeConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionRateConfiguration;
import com.gamifyverse.gamifyapi.trigger.service.TriggerService;
import com.gamifyverse.gamifyapi.trigger.usecases.command.CreateTriggerCommand;

import jakarta.transaction.Transactional;

@Component
public class CreateTriggerUseCase {

	@Autowired
	private TriggerPersistenceAdapter persistenceAdapter;

	@Autowired
	private TriggerService triggerService;

	private void handleCreateConfiguration(CreateTriggerCommand command, Trigger trigger) {
		if (!trigger.hasToCreateConfiguration()) {
			return;
		}
		TriggerExecutionConfiguration configuration = triggerService.createTriggerConfiguration(trigger, command);
		persistenceAdapter.persistConfiguration(configuration);
	}

	private void handleCreateAttributeConfiguration(CreateTriggerCommand command, Trigger trigger) {
		if (!trigger.hasToCreateAttributeConfiguration()) {
			return;
		}
		TriggerExecutionAttributeConfiguration configuration = triggerService
				.createTriggerAttributeConfiguration(trigger, command);
		persistenceAdapter.persistConfiguration(configuration);
	}

	private void handleCreateRateConfiguration(CreateTriggerCommand command, Trigger trigger) {
		if (!trigger.hasToCreateRateConfiguration()) {
			return;
		}
		TriggerExecutionRateConfiguration configuration = triggerService.createTriggerRateConfguration(trigger,
				command);
		persistenceAdapter.persistConfiguration(configuration);
	}

	@Transactional
	public Trigger handle(CreateTriggerCommand command) {
		Trigger trigger = triggerService.createTrigger(command);
		trigger = persistenceAdapter.persistTrigger(trigger);
		this.handleCreateConfiguration(command, trigger);
		this.handleCreateAttributeConfiguration(command, trigger);
		this.handleCreateRateConfiguration(command, trigger);
		return trigger;
	}

}
