package com.gamifyverse.gamifyapi.trigger.model;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TriggerRateTypeEnum {
	FIXRATE(1l, "TAXA FIXA"), VARIABLERATE(2l, "TAXA VARIÀVEL"),;

	private Long id;
	private String name;

	public static TriggerRateTypeEnum fromId(Long id) {
		return Arrays.asList(values()).stream().filter(at -> at.id == id).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("There is no trigger type for id %d", id)));
	}
}
