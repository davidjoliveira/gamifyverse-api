package com.gamifyverse.gamifyapi.action.model;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionTypeEnum {
	USER_ACTION(1l, "ACAO DE USUARIO"), SCHEDULED_ACTION(2l, "ACAO AGENDADA"), SYSTEM_ACTION(3l, "ACAO DE SISTEMA"),;

	private Long id;
	private String name;

	public static ActionTypeEnum fromId(Long id) {
		return Arrays.asList(values()).stream().filter(at -> at.id == id).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("The is no action type for id %d", id)));
	}
}
