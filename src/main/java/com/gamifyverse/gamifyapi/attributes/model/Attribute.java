package com.gamifyverse.gamifyapi.attributes.model;

import java.util.UUID;

import com.gamifyverse.gamifyapi.game.model.Game;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Attribute {
	private Long id;
	private Game game;
	private String name;
	private String description;
	private UUID externalUUID;
	private AttributeType attributeType;
	private Boolean active;

	public static Attribute createAttribute(String name, String description, AttributeType attributeType, Game game) {
		return new Attribute(null, game, name, description, UUID.randomUUID(), attributeType, true);
	}

}
