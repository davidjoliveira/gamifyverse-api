package com.gamifyverse.gamifyapi.trigger.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TriggerExecutionConfiguration {
	private Long id;
	private Trigger trigger;
	private Integer executionTimes;

	public static TriggerExecutionConfiguration createExecutionConfiguration(Trigger trigger, Integer executionTimes) {
		if (trigger == null || trigger.getId() == null) {
			throw new RuntimeException("You must provide a persisted trigger to create a execution configuration");
		}
		if (executionTimes == null || executionTimes <= 0) {
			throw new RuntimeException(
					"You must provide an execution times descriving how many times this trigger will be executed");
		}
		return new TriggerExecutionConfiguration(null, trigger, executionTimes);
	}
}
