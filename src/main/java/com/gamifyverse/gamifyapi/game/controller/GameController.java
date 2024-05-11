package com.gamifyverse.gamifyapi.game.controller;

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

import com.gamifyverse.gamifyapi.game.controller.dto.CreateGameDto;
import com.gamifyverse.gamifyapi.game.controller.dto.GameDto;
import com.gamifyverse.gamifyapi.game.controller.mappers.GameDtoMapper;
import com.gamifyverse.gamifyapi.game.model.Game;
import com.gamifyverse.gamifyapi.game.usecases.GetGamesUseCase;
import com.gamifyverse.gamifyapi.game.usecases.SaveGameUseCase;
import com.gamifyverse.gamifyapi.game.usecases.commands.GetGameCommand;
import com.gamifyverse.gamifyapi.game.usecases.commands.GetGamesCommand;
import com.gamifyverse.gamifyapi.game.usecases.commands.SaveGameCommand;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.apachecommons.CommonsLog;

@RequestMapping(path = "/game")
@RestController
@CrossOrigin
@CommonsLog
public class GameController {

	@Autowired
	private SaveGameUseCase saveGame;

	@Autowired
	private GetGamesUseCase getGames;

	@Autowired
	private GameDtoMapper gameDtoMapper;

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GameDto> createProduct(@Valid @RequestBody CreateGameDto body) {
		log.info(String.format("Received game creation request with data %s", body.toString()));

		SaveGameCommand command = SaveGameCommand.from(body);
		Game response = saveGame.handle(command);

		log.debug(String.format("Answering game creation request with data %s", response.toString()));
		return new ResponseEntity<>(gameDtoMapper.toDto(response), HttpStatus.CREATED);
	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GameDto>> listGames() {
		log.info("Received game list get request");
		List<Game> response = getGames.handle(new GetGamesCommand());

		return new ResponseEntity<List<GameDto>>(gameDtoMapper.fromListDomain(response), HttpStatus.OK);
	}

	@GetMapping(path = "/{gameUUID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GameDto> getGame(@PathVariable("gameUUID") @NotNull @NotEmpty @Valid String gameUUID) {
		log.info(String.format("Received get game by uuid for %s", gameUUID));
		Game response = getGames.handle(new GetGameCommand(UUID.fromString(gameUUID)));

		return new ResponseEntity<GameDto>(gameDtoMapper.toDto(response), HttpStatus.OK);
	}

}
