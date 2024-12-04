package com.gamifyverse.gamifyapi.trigger.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.trigger.adapters.TriggerPersistenceAdapter;
import com.gamifyverse.gamifyapi.trigger.model.TriggerCalculationAssociation;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggerCalculationAssociationCommand;

@Component
public class GetTriggerCalculationAssociationUseCase {

	@Autowired
	private TriggerPersistenceAdapter triggerPersistenceAdapter;

	public List<TriggerCalculationAssociation> handle(GetTriggerCalculationAssociationCommand command) {
		return triggerPersistenceAdapter.getTriggerCalculationAssociationsByTriggerUUID(command.getTriggerUUID());
	}

}
