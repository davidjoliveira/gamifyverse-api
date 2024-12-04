package com.gamifyverse.gamifyapi.trigger.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.trigger.adapters.TriggerPersistenceAdapter;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerCalculationAssociation;
import com.gamifyverse.gamifyapi.trigger.service.TriggerCalculationAssociationService;
import com.gamifyverse.gamifyapi.trigger.usecases.command.CreateTriggerCalculationAssociationCommand;

@Component
public class CreateTriggerCalculationAssociationUseCase {

	@Autowired
	private TriggerPersistenceAdapter triggerPersistenceAdapter;

	@Autowired
	private TriggerCalculationAssociationService triggerAssociationService;

	public List<TriggerCalculationAssociation> handle(CreateTriggerCalculationAssociationCommand command) {
		List<TriggerCalculationAssociation> currentData = triggerPersistenceAdapter
				.getTriggerCalculationAssociationsByTriggerUUID(command.getTriggerUUID());
		Trigger trigger = triggerPersistenceAdapter.getTriggerByExternalUUID(command.getTriggerUUID()).orElseThrow(
				() -> new RuntimeException(String.format("Not found trigger for uuid %s", command.getTriggerUUID())));
		List<TriggerCalculationAssociation> newData = triggerAssociationService.mergeData(currentData,
				command.getCalculationUUIDs(), trigger);
		// get current associations
		// check for orders updates
		// create list for updates
		// create list for inserts
		// if incoming list is smaller or same size, than will have just updates
		// execute updates, execute inserts
		return triggerPersistenceAdapter.upsertTriggerCalculationAssociations(newData);
	}

}
