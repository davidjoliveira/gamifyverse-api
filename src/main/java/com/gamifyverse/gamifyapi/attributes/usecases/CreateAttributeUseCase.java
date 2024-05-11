package com.gamifyverse.gamifyapi.attributes.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.attributes.adapters.AttributePersistenceAdapter;
import com.gamifyverse.gamifyapi.attributes.model.Attribute;
import com.gamifyverse.gamifyapi.attributes.service.AttributeService;
import com.gamifyverse.gamifyapi.attributes.usecases.command.CreateAttributeCommand;

@Component
public class CreateAttributeUseCase {

	@Autowired
	private AttributeService attributeService;

	@Autowired
	private AttributePersistenceAdapter attributePersistenceAdapter;

	public Attribute handle(CreateAttributeCommand command) {
		Attribute attribute = attributeService.createAttribute(command);
		return attributePersistenceAdapter.persistAttribute(attribute);
	}

}
