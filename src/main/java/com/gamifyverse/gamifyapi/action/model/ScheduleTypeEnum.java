package com.gamifyverse.gamifyapi.action.model;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScheduleTypeEnum {
	DAILY(1l, "DIARIO"), ONCEATIME(2l, "EXECUCAO UNICA"), CRON(3l, "CRON"),;

	private Long id;
	private String name;

	public static ScheduleTypeEnum fromId(Long id) {
		return Arrays.asList(values()).stream().filter(st -> st.id == id).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("There is no schedule type for id %d", id)));
	}

}
