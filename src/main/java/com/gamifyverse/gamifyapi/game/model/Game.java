package com.gamifyverse.gamifyapi.game.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
	private Long id;
	private String name;
	private String description;
	private UUID externalUUID;
	private GameAPIConfiguration gameAPIConfiguration;
	
	public static Game newGame(String name, String description) {
		return new Game(null, name, description, UUID.randomUUID(), null);
	}
	
	public Game createConfiguration() {
		if (gameAPIConfiguration == null) {
			gameAPIConfiguration = new GameAPIConfiguration(0l, this.id, "");
		}
		return this;
	}

}
