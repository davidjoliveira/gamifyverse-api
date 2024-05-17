package com.gamifyverse.gamifyapi.trigger.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TriggerExecutionRateConfiguration {
	private Long id;
	private Trigger trigger;
	private TriggerRateType triggerRateType;
	private Double baseRate;
	private Double incrementRate;

	public static TriggerExecutionRateConfiguration createRateConfiguration(Trigger trigger,
			TriggerRateType triggerRateType, Double baseRate, Double incrementRate) {
		if (trigger == null || trigger.getId() == null) {
			throw new RuntimeException("You must provide a persisted trigger to create a attribute configuration");
		}
		if (triggerRateType == null) {
			throw new RuntimeException(
					"You must provide a trigger rate to associate on trigger rate configuration creation");
		}
		if (baseRate == null || baseRate < 0.0) {
			throw new RuntimeException("You must provide a trigger base rate to create a trigger rate configuration");
		}

		TriggerRateTypeEnum enumm = TriggerRateTypeEnum.fromId(triggerRateType.getId());
		if (enumm == TriggerRateTypeEnum.VARIABLERATE && (incrementRate == null || incrementRate < 0.0)) {
			throw new RuntimeException(
					"You must provide a trigger increment rate to create a trigger rate configuration of type variable rate");
		} else {
			incrementRate = null;
		}
		return new TriggerExecutionRateConfiguration(null, trigger, triggerRateType, baseRate, incrementRate);
	}
}
