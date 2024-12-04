package com.gamifyverse.gamifyapi.calculation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CalculationOriginValueTypeEnum {
	PARAM(1l, "PARÂMETRO DA CHAMADA"), ATTRIBUTE(2l, "ATRIBUTO DO JOGADOR");

	private Long id;
	private String name;

}
