package com.gamifyverse.gamifyapi.player.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gamifyverse.gamifyapi.game.model.Game;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
	private Long id;
	private Game game;
	private UUID externalUUID;
	private LocalDateTime creationDate;
	private Boolean active;

	public static Player from(Game game) {
		if (game == null || game.getId() == null) {
			throw new RuntimeException("Game must be infomed on player creation");
		}
		return new Player(null, game, UUID.randomUUID(), LocalDateTime.now(), Boolean.TRUE);
	}
}
