package com.gamifyverse.gamifyapi.common;

import lombok.Value;

@Value
public class ErrorData {
	private String code;
	private String message;
}
