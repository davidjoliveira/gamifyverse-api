package com.gamifyverse.gamifyapi.trigger.model;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TriggerTypeEnum {
	EXECUTEALWAYS(1l, "EXECUTA TODAS AS VEZES"), EXECUTEONCE(2l, "EXECUTA APENAS UMA VEZ"),
	EXECUTERANDOM(3l, "EXECUTA DE FORMA ALEATÓRIA"), EXECUTENTIMES(4l, "EXECUTA X VEZES"),
	EXECUTEATTRIBUTEVALUEGT(5l, "EXECUTA ATRIBUTO VALOR MAIOR"),
	EXECUTEATTRIBUTEVALUELT(6l, "EXECUTA ATRIBUTO VALOR MENOR"),
	EXECUTEATTRIBUTEVALUEEQ(6l, "EXECUTA ATRIBUTO VALOR IGUAL"),;

	private Long id;
	private String name;

	public static TriggerTypeEnum fromId(Long id) {
		return Arrays.asList(values()).stream().filter(at -> at.id == id).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("There is no trigger type for id %d", id)));
	}
}
