package com.gamifyverse.gamifyapi.trigger.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerCalculationAssociation;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionAttributeConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionRateConfiguration;

public interface TriggerPersistenceAdapter {
	public Trigger persistTrigger(Trigger trigger);

	public TriggerExecutionConfiguration persistConfiguration(TriggerExecutionConfiguration config);

	public TriggerExecutionAttributeConfiguration persistConfiguration(TriggerExecutionAttributeConfiguration config);

	public TriggerExecutionRateConfiguration persistConfiguration(TriggerExecutionRateConfiguration config);

	public List<Trigger> getTriggersByGameUUID(UUID gameUUID);

	public Optional<Trigger> getTriggerByExternalUUID(UUID triggerUUID);

	public List<TriggerCalculationAssociation> getTriggerCalculationAssociationsByTriggerUUID(UUID triggerUUID);

	public List<TriggerCalculationAssociation> upsertTriggerCalculationAssociations(
			List<TriggerCalculationAssociation> currentAssociations);
}
