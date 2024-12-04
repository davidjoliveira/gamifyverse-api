package com.gamifyverse.gamifyapi.calculation.model;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CalculationBonusTypeEnum {
	FIXED(1l, "BÔNUS FIXO"), RANGE(2l, "ALEATÓRIO DENTRO DE INTERVALO"),;

	private Long id;
	private String name;

	public static CalculationBonusTypeEnum fromId(Long id) {
		return Arrays.asList(values()).stream().filter(v -> v.id == id).findFirst().orElseThrow(
				() -> new RuntimeException(String.format("Not found calculation bonus type with id %d", id)));
	}

}
