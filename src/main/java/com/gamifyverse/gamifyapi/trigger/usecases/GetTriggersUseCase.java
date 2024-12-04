package com.gamifyverse.gamifyapi.trigger.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.trigger.adapters.TriggerPersistenceAdapter;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggerByExternalUUIDCommand;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggersByGameCommand;

@Component
public class GetTriggersUseCase {

	@Autowired
	private TriggerPersistenceAdapter triggerPersistenceAdapter;

	public List<Trigger> handle(GetTriggersByGameCommand command) {
		return triggerPersistenceAdapter.getTriggersByGameUUID(command.getGameUUID());
	}

	public Trigger handle(GetTriggerByExternalUUIDCommand command) {
		return triggerPersistenceAdapter.getTriggerByExternalUUID(command.getGameUUID()).orElseThrow(
				() -> new RuntimeException(String.format("Not found trigger for UUID %s", command.getGameUUID())));
	}

}
