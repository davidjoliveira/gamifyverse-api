package com.gamifyverse.gamifyapi.attributes.controller;

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

import com.gamifyverse.gamifyapi.attributes.controller.dto.AttributeDto;
import com.gamifyverse.gamifyapi.attributes.controller.dto.AttributeTypeDto;
import com.gamifyverse.gamifyapi.attributes.controller.mappers.AttributeDtoMapper;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.attributes.model.AttributeType;
import com.gamifyverse.gamifyapi.attributes.usecases.GetAttributeTypesUseCase;
import com.gamifyverse.gamifyapi.attributes.usecases.GetAttributesUseCase;
import com.gamifyverse.gamifyapi.attributes.usecases.command.GetAttributeTypesCommand;
import com.gamifyverse.gamifyapi.attributes.usecases.command.GetAttributesByGameUUIDCommand;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.apachecommons.CommonsLog;

@RequestMapping(path = "/attribute")
@RestController
@CrossOrigin
@CommonsLog
public class AttributeController {

	@Autowired
	private GetAttributeTypesUseCase getAttributeTypesUseCase;

	@Autowired
	private GetAttributesUseCase getAttributes;

	@Autowired
	private AttributeDtoMapper attributeMapper;

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAttribute(@Valid @RequestBody Object body) {
		return null;
	}

	@GetMapping(path = "/game/{gameUUID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttributeDto>> getAttributesForGame(
			@PathVariable("gameUUID") @NotNull @NotEmpty @Valid String gameUUID) {
		log.info(String.format("Getting attributes for game %s", gameUUID));
		List<Attribute> result = getAttributes.handle(new GetAttributesByGameUUIDCommand(UUID.fromString(gameUUID)));
		return new ResponseEntity<List<AttributeDto>>(attributeMapper.toAttributeDtoList(result), HttpStatus.OK);
	}

	@GetMapping(path = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttributeTypeDto>> listGames() {
		log.info("Getting attributes types");
		List<AttributeType> result = getAttributeTypesUseCase.handle(new GetAttributeTypesCommand());
		return new ResponseEntity<List<AttributeTypeDto>>(attributeMapper.toAttributeTypeDtoList(result),
				HttpStatus.OK);
	}

}
