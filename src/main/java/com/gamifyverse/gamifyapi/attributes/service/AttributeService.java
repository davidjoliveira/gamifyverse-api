package com.gamifyverse.gamifyapi.attributes.service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.attributes.adapters.AttributeTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.attributes.model.AttributeType;
import com.gamifyverse.gamifyapi.attributes.usecases.command.CreateAttributeCommand;
import com.gamifyverse.gamifyapi.game.adapters.GamePersistenceAdapter;
import com.gamifyverse.gamifyapi.game.model.Game;

@Service
public class AttributeService {

	@Autowired
	private AttributeTypePersistenceAdapter attributeTypeAdapter;

	@Autowired
	private GamePersistenceAdapter gameAdapter;

	@Async
	public CompletableFuture<Game> getGameByUUID(UUID gameUUID) {
		Optional<Game> game = gameAdapter.getGameByExternalUUID(gameUUID);
		return CompletableFuture.<Game>completedFuture(
				game.orElseThrow(() -> new RuntimeException(String.format("Not found game for UUID %s", gameUUID))));
	}

	@Async
	public CompletableFuture<AttributeType> getAttributeTypeByUUID(UUID attributeTypeUUID) {
		Optional<AttributeType> attrType = attributeTypeAdapter.getAttributeTypeByUUID(attributeTypeUUID);
		return CompletableFuture.<AttributeType>completedFuture(attrType.orElseThrow(
				() -> new RuntimeException(String.format("Error while getting attribute type %s", attributeTypeUUID))));
	}

	public Attribute createAttribute(CreateAttributeCommand command) {
		try {
			return getGameByUUID(command.getGameUUID())
					.thenCompose(g -> getAttributeTypeByUUID(command.getAttributeTypeUUID()).thenApply(
							at -> Attribute.createAttribute(command.getName(), command.getDescription(), at, g)))
					.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException("Error while creating attribute", e);
		}
	}

}
