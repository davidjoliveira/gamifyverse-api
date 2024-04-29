package com.gamifyverse.gamifyapi.attributes.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.attributes.adapters.AttributePersistenceAdapter;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.attributes.usecases.command.GetAttributesByGameUUIDCommand;

@Component
public class GetAttributesUseCase {

	@Autowired
	private AttributePersistenceAdapter attributePersistenceAdapter;

	public List<Attribute> handle(GetAttributesByGameUUIDCommand command) {
		return attributePersistenceAdapter.getAttributesByGameUUID(command.getGameUUID());
	}

}
