package com.gamifyverse.gamifyapi.player.controller.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class PlayerDto {
	private UUID gameUUID;
	private UUID externalUUID;
	private LocalDateTime creationDate;
	private Boolean active;
}
