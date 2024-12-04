package com.gamifyverse.gamifyapi.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamifyverse.gamifyapi.player.controller.dto.PlayerDto;
import com.gamifyverse.gamifyapi.player.controller.mappers.PlayerDtoMapper;
import com.gamifyverse.gamifyapi.player.model.Player;
import com.gamifyverse.gamifyapi.player.usecases.CreatePlayerUseCase;
import com.gamifyverse.gamifyapi.player.usecases.command.CreatePlayerCommand;

import jakarta.validation.Valid;
import lombok.extern.apachecommons.CommonsLog;

@RequestMapping(path = "/player")
@RestController
@CrossOrigin
@CommonsLog
public class PlayerController {

	@Autowired
	private CreatePlayerUseCase createPlayerUseCase;

	@Autowired
	private PlayerDtoMapper mapper;

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlayerDto> createPlayer(@Valid @RequestBody PlayerDto body) {
		log.info(String.format("Creating player for game %s", body.getGameUUID()));
		Player player = createPlayerUseCase.handle(CreatePlayerCommand.from(body));
		return new ResponseEntity<PlayerDto>(mapper.toDto(player), HttpStatus.CREATED);
	}

}
