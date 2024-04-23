package com.gamifyverse.gamifyapi.game.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gamifyverse.gamifyapi.common.ErrorResponseDto;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GameControllerAdvice {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponseDto> handleConstraintViolation(ConstraintViolationException ex) {
		ErrorResponseDto errorResponse = new ErrorResponseDto();
		ex.getConstraintViolations().forEach(c -> {
			errorResponse.addNewError(null, c.getMessage());
		});
		return new ResponseEntity<ErrorResponseDto>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
