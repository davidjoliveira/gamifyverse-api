package com.gamifyverse.gamifyapi.trigger.adapters;

import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionAttributeConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionConfiguration;
import com.gamifyverse.gamifyapi.trigger.model.TriggerExecutionRateConfiguration;

public interface TriggerPersistenceAdapter {
	public Trigger persistTrigger(Trigger trigger);

	public TriggerExecutionConfiguration persistConfiguration(TriggerExecutionConfiguration config);

	public TriggerExecutionAttributeConfiguration persistConfiguration(TriggerExecutionAttributeConfiguration config);

	public TriggerExecutionRateConfiguration persistConfiguration(TriggerExecutionRateConfiguration config);
}
