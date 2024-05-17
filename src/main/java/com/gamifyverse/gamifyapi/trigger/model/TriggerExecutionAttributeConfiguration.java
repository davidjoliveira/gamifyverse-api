package com.gamifyverse.gamifyapi.trigger.model;

import com.gamifyverse.gamifyapi.attributes.model.Attribute;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TriggerExecutionAttributeConfiguration {
	private Long id;
	private Trigger trigger;
	private Attribute attribute; // Indica qual atributo é verificado em triggers acionadas quando o valor do
									// atributo é x
	private Double attributeValue;

	public static TriggerExecutionAttributeConfiguration createAttributeConfiguration(Trigger trigger,
			Attribute attribute, Double attributeValue) {
		if (trigger == null || trigger.getId() == null) {
			throw new RuntimeException("You must provide a persisted trigger to create a attribute configuration");
		}
		if (attribute == null) {
			throw new RuntimeException("You must provide a attribute to create a attribute configuration");
		}
		if (attributeValue == null) {
			throw new RuntimeException("You must provide a value to create a attribute configuration");
		}

		return new TriggerExecutionAttributeConfiguration(null, trigger, attribute, attributeValue);
	}
}
