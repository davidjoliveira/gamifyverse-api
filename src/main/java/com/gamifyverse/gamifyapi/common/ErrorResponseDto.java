package com.gamifyverse.gamifyapi.common;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResponseDto {
	private List<ErrorData> errorsList = new ArrayList<>();
	
	public ErrorResponseDto addNewError(String code, String message) {
		this.errorsList.add(new ErrorData(code, message));
		return this;
	}
}
