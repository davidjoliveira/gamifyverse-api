package com.gamifyverse.gamifyapi.action.controller;

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
import com.gamifyverse.gamifyapi.action.controller.dto.ActionTypeDto;
import com.gamifyverse.gamifyapi.action.controller.dto.CreateActionDto;
import com.gamifyverse.gamifyapi.action.controller.dto.ScheduleTypeDto;
import com.gamifyverse.gamifyapi.action.controller.mappers.ActionDtoMapper;
import com.gamifyverse.gamifyapi.action.model.Action;
import com.gamifyverse.gamifyapi.action.model.ActionType;
import com.gamifyverse.gamifyapi.action.model.ScheduleType;
import com.gamifyverse.gamifyapi.action.usecases.CreateActionUseCase;
import com.gamifyverse.gamifyapi.action.usecases.GetActionAndScheduleTypesUseCase;
import com.gamifyverse.gamifyapi.action.usecases.command.CreateActionCommand;
import com.gamifyverse.gamifyapi.action.usecases.command.GetActionTypesCommand;
import com.gamifyverse.gamifyapi.action.usecases.command.GetActionsByGameCommand;
import com.gamifyverse.gamifyapi.action.usecases.command.GetScheduleTypesCommand;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.apachecommons.CommonsLog;

@RequestMapping(path = "/action")
@RestController
@CrossOrigin
@CommonsLog
public class ActionController {

	@Autowired
	private GetActionAndScheduleTypesUseCase getActionAndScheduleTypes;

	@Autowired
	private CreateActionUseCase createActionUseCase;

	@Autowired
	private ActionDtoMapper mapper;

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ActionDto> createAttribute(@Valid @RequestBody CreateActionDto body) {
		log.info(String.format("Creating action for game %s", body.getGameUUID()));
		Action action = createActionUseCase.handle(CreateActionCommand.from(body));
		return new ResponseEntity<ActionDto>(mapper.toDto(action), HttpStatus.CREATED);
	}

	@GetMapping(path = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ActionTypeDto>> listActionTypes() {
		log.info("Getting action types");
		List<ActionType> actionType = getActionAndScheduleTypes.handle(new GetActionTypesCommand());
		return new ResponseEntity<List<ActionTypeDto>>(mapper.toActionTypeDtoList(actionType), HttpStatus.OK);
	}

	@GetMapping(path = "/game/{gameUUID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ActionDto>> getActionsForGame(
			@PathVariable("gameUUID") @NotNull @NotEmpty @Valid String gameUUID) {
		log.info(String.format("Getting actions for game %s", gameUUID));
		List<Action> result = getActionAndScheduleTypes.handle(new GetActionsByGameCommand(UUID.fromString(gameUUID)));
		return new ResponseEntity<List<ActionDto>>(mapper.toActionDtoList(result), HttpStatus.OK);
	}

	@GetMapping(path = "/schedule/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScheduleTypeDto>> listScheduleTypes() {
		log.info("Getting schedule types");
		List<ScheduleType> scheduleTypes = getActionAndScheduleTypes.handle(new GetScheduleTypesCommand());
		return new ResponseEntity<List<ScheduleTypeDto>>(mapper.toScheduleTypeDtoList(scheduleTypes), HttpStatus.OK);
	}

}
