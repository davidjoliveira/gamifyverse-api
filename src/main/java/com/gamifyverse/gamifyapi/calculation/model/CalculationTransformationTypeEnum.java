package com.gamifyverse.gamifyapi.calculation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CalculationTransformationTypeEnum {
	TIMETOHOURS(1l, "STRING PARA HORAS"), TIMETOMINUTES(2l, "STRING PARA MINUTOS"),
	TRANSFORMATIONTABLE(3l, "TABELA DE TRANSFORMAÇÃO");

	private Long id;
	private String name;

}
