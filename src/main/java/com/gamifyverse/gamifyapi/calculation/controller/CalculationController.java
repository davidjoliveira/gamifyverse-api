package com.gamifyverse.gamifyapi.calculation.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamifyverse.gamifyapi.action.controller.dto.ActionDto;
import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.usecases.command.GetActionsByGameCommand;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationBonusTypeDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationMathTypeDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationTransformationTypeDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CalculationTypeDto;
import com.gamifyverse.gamifyapi.calculation.controller.dto.CreateCalculationDto;
import com.gamifyverse.gamifyapi.calculation.controller.mapper.CalculationDtoMapper;
import com.gamifyverse.gamifyapi.calculation.model.Calculation;
import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationType;
import com.gamifyverse.gamifyapi.calculation.usecases.CreateCalculationUseCase;
import com.gamifyverse.gamifyapi.calculation.usecases.GetCalculationTypesUseCase;
import com.gamifyverse.gamifyapi.calculation.usecases.GetCalculationsUseCase;
import com.gamifyverse.gamifyapi.calculation.usecases.command.CreateCalculationCommand;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationBonusTypesCommand;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationMathTypesCommand;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationTransformationTypesCommand;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationTypesCommand;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationsByGameCommand;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.apachecommons.CommonsLog;

@RequestMapping(path = "/calculation")
@RestController
@CrossOrigin
@CommonsLog
public class CalculationController {

	@Autowired
	private GetCalculationTypesUseCase getCalculationTypes;

	@Autowired
	private CreateCalculationUseCase createCalculation;

	@Autowired
	private GetCalculationsUseCase getCalculations;

	@Autowired
	private CalculationDtoMapper calculationMapper;

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createCalculation(@Valid @RequestBody CreateCalculationDto body) {
		log.info(String.format("Creating calculation for game %s", body.getGameUUID()));
		Calculation calculation = createCalculation.handle(CreateCalculationCommand.from(body));
		return new ResponseEntity<>(calculationMapper.toDto(calculation), HttpStatus.CREATED);
	}

	@GetMapping(path = "/game/{gameUUID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalculationDto>> getCalculationsForGame(
			@PathVariable("gameUUID") @NotNull @NotEmpty @Valid String gameUUID) {
		log.info(String.format("Getting calculations for game %s", gameUUID));
		List<Calculation> result = getCalculations.handle(GetCalculationsByGameCommand.from(gameUUID));
		return new ResponseEntity<List<CalculationDto>>(calculationMapper.toCalculationDtoList(result), HttpStatus.OK);
	}

	@GetMapping(path = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalculationTypeDto>> listCalculationTypes() {
		log.info("Getting trigger types");
		List<CalculationType> result = getCalculationTypes.handle(new GetCalculationTypesCommand());
		return new ResponseEntity<List<CalculationTypeDto>>(calculationMapper.toCalculationTypeDtoList(result),
				HttpStatus.OK);
	}

	@GetMapping(path = "math/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalculationMathTypeDto>> listCalculationMathTypes() {
		log.info("Getting trigger types");
		List<CalculationMathType> result = getCalculationTypes.handle(new GetCalculationMathTypesCommand());
		return new ResponseEntity<List<CalculationMathTypeDto>>(calculationMapper.toCalculationMathTypeDtoList(result),
				HttpStatus.OK);
	}

	@GetMapping(path = "transformation/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalculationTransformationTypeDto>> listCalculationTransformationTypes() {
		log.info("Getting trigger types");
		List<CalculationTransformationType> result = getCalculationTypes
				.handle(new GetCalculationTransformationTypesCommand());
		return new ResponseEntity<List<CalculationTransformationTypeDto>>(
				calculationMapper.toCalculationTransformationTypeDtoList(result), HttpStatus.OK);
	}

	@GetMapping(path = "bonus/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalculationBonusTypeDto>> listCalculationBonusTypes() {
		log.info("Getting trigger types");
		List<CalculationBonusType> result = getCalculationTypes.handle(new GetCalculationBonusTypesCommand());
		return new ResponseEntity<List<CalculationBonusTypeDto>>(
				calculationMapper.toCalculationBonusTypeDtoList(result), HttpStatus.OK);
	}
}
