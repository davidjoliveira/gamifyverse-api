package com.gamifyverse.gamifyapi.trigger.model;

import com.gamifyverse.gamifyapi.calculation.model.Calculation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TriggerCalculationAssociation {
	private Long id;
	private Trigger trigger;
	private Calculation calculation;
	private Integer order;
	private Boolean active;
	
	public static TriggerCalculationAssociation from(Trigger trigger, Calculation calculation, Integer order) {
		if (trigger == null || trigger.getId() == null) {
			throw new RuntimeException("You must provide a valid trigger to create an assiciation with a calculation");
		}
		if (calculation == null || calculation.getId() == null) {
			throw new RuntimeException("You must provide a valid calculation to create an assiciation with a trigger");
		}
		if (order <= 0) {
			throw new RuntimeException("The order value to make an association between trigger and calculation must be greater than zero");
		}
		return new TriggerCalculationAssociation(null, trigger, calculation, order, true);
	}
}
