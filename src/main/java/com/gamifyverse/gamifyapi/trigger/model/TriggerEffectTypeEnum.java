package com.gamifyverse.gamifyapi.trigger.model;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TriggerEffectTypeEnum {
	PRIZE(1l, "PREMIO"), CHALLENGE(1l, "DESAFIO"), ATTRIBUTECHANGE(1l, "INCREMENTO ATRIBUTO"),;

	private Long id;
	private String name;

	public static TriggerEffectTypeEnum fromId(Long id) {
		return Arrays.asList(values()).stream().filter(at -> at.id == id).findFirst().orElseThrow(
				() -> new RuntimeException(String.format("There is no trigger effect type for id %d", id)));
	}

}
