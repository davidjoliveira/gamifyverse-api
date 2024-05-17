package com.gamifyverse.gamifyapi.trigger.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.trigger.adapters.TriggerTypeValuesPersistenceAdapter;
import com.gamifyverse.gamifyapi.trigger.model.TriggerEffectType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerRateType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerType;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggerEffectTypesCommand;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggerRateTypesCommand;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggerTypesCommand;

@Component
public class GetTriggerTypesValuesUseCase {

	@Autowired
	private TriggerTypeValuesPersistenceAdapter triggerTypesPersistence;

	public List<TriggerType> handle(GetTriggerTypesCommand command) {
		return triggerTypesPersistence.getAllTriggerTypes();
	}

	public List<TriggerEffectType> handle(GetTriggerEffectTypesCommand command) {
		return triggerTypesPersistence.getAllTriggerEffectTypes();
	}

	public List<TriggerRateType> handle(GetTriggerRateTypesCommand command) {
		return triggerTypesPersistence.getAllTriggerRateTypes();
	}

}
