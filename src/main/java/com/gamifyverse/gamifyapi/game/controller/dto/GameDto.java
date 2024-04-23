package com.gamifyverse.gamifyapi.game.controller.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class GameDto {
	private String name;
	private UUID externalUUID;
}
