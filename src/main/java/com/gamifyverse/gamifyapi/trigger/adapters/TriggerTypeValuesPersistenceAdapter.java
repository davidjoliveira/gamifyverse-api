package com.gamifyverse.gamifyapi.trigger.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gamifyverse.gamifyapi.trigger.model.TriggerEffectType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerRateType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerType;

public interface TriggerTypeValuesPersistenceAdapter {
	List<TriggerType> getAllTriggerTypes();

	Optional<TriggerType> findTriggerTypeByUUID(UUID triggerTypeUUID);

	List<TriggerEffectType> getAllTriggerEffectTypes();

	Optional<TriggerEffectType> findTriggerEffectByUUID(UUID triggerEffectUUID);

	List<TriggerRateType> getAllTriggerRateTypes();

	Optional<TriggerRateType> findTriggerRateByUUID(UUID triggerRateUUID);
}
