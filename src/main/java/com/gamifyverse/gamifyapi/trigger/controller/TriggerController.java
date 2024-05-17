package com.gamifyverse.gamifyapi.trigger.controller;

import java.util.List;

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

import com.gamifyverse.gamifyapi.trigger.controller.dto.CreateTriggerDto;
import com.gamifyverse.gamifyapi.trigger.controller.dto.TriggerDto;
import com.gamifyverse.gamifyapi.trigger.controller.dto.TriggerEffectTypeDto;
import com.gamifyverse.gamifyapi.trigger.controller.dto.TriggerRateTypeDto;
import com.gamifyverse.gamifyapi.trigger.controller.dto.TriggerTypeDto;
import com.gamifyverse.gamifyapi.trigger.controller.mapper.TriggerDtoMapper;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerEffectType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerRateType;
import com.gamifyverse.gamifyapi.trigger.model.TriggerType;
import com.gamifyverse.gamifyapi.trigger.usecases.CreateTriggerUseCase;
import com.gamifyverse.gamifyapi.trigger.usecases.GetTriggerTypesValuesUseCase;
import com.gamifyverse.gamifyapi.trigger.usecases.command.CreateTriggerCommand;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggerEffectTypesCommand;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggerRateTypesCommand;
import com.gamifyverse.gamifyapi.trigger.usecases.command.GetTriggerTypesCommand;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.apachecommons.CommonsLog;

@RequestMapping(path = "/trigger")
@RestController
@CrossOrigin
@CommonsLog
public class TriggerController {

	@Autowired
	private GetTriggerTypesValuesUseCase getTriggerTypeValues;

	@Autowired
	private CreateTriggerUseCase createTriggerUseCase;

	@Autowired
	private TriggerDtoMapper triggerMapper;

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TriggerDto> createTrigger(@Valid @RequestBody CreateTriggerDto body) {
		log.info(String.format("Creating trigger for game %s", body.getGameUUID()));
		Trigger result = createTriggerUseCase.handle(CreateTriggerCommand.from(body));
		return new ResponseEntity<TriggerDto>(triggerMapper.toDto(result), HttpStatus.CREATED);
	}

	@GetMapping(path = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TriggerTypeDto>> listTriggerTypes() {
		log.info("Getting trigger types");
		List<TriggerType> result = getTriggerTypeValues.handle(new GetTriggerTypesCommand());
		return new ResponseEntity<List<TriggerTypeDto>>(triggerMapper.toTriggerTypeDtoList(result), HttpStatus.OK);
	}

	@GetMapping(path = "/trigger-effects/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TriggerEffectTypeDto>> listTriggerEffectTypes() {
		log.info("Getting trigger types");
		List<TriggerEffectType> result = getTriggerTypeValues.handle(new GetTriggerEffectTypesCommand());
		return new ResponseEntity<List<TriggerEffectTypeDto>>(triggerMapper.toTriggerEffectDtoList(result),
				HttpStatus.OK);
	}

	@GetMapping(path = "/game/{gameUUID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> getTriggersForGame(
			@PathVariable("gameUUID") @NotNull @NotEmpty @Valid String gameUUID) {
		log.info(String.format("Getting actions for game %s", gameUUID));
		return null;
	}

	@GetMapping(path = "/trigger-rate/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TriggerRateTypeDto>> listTriggerRateTypes() {
		log.info("Getting trigger rates types");
		List<TriggerRateType> result = getTriggerTypeValues.handle(new GetTriggerRateTypesCommand());
		return new ResponseEntity<List<TriggerRateTypeDto>>(triggerMapper.toTriggerRateDtoList(result), HttpStatus.OK);
	}

}
