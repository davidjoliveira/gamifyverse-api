package com.gamifyverse.gamifyapi.calculation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CalculationMathTypeEnum {
	SUM(1l, "SOMA"), SUBTRACTION(2l, "SUBTRAÇÃO"), MULTIPLICATION(3l, "MULTIPLICAÇÃO"), DIVISION(4l, "DIVISÃO"),
	POW(5l, "POTÊNCIA"), SQRT(6l, "RAIZ QUADRADA");

	private Long id;
	private String name;
}
