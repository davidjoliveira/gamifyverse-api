package com.gamifyverse.gamifyapi.calculation.model;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CalculationTypeEnum {
	MATH(1l, "CÁLCULO MATEMÁTICO"), TRANSFORMATION(2l, "CONVERSÃO DE VALOR"), BONUS(3l, "APLICAÇÃO DE BÔNUS"),;

	private Long id;
	private String name;

	public static CalculationTypeEnum fromId(Long id) {
		return Arrays.asList(values()).stream().filter(v -> v.id == id).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("There is no calculation type for id %d", id)));
	}

}
