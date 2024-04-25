package com.gamifyverse.gamifyapi.attributes.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.attributes.adapters.AttributeTypePersistenceAdapter;
import com.gamifyverse.gamifyapi.attributes.model.AttributeType;
import com.gamifyverse.gamifyapi.attributes.usecases.command.GetAttributeTypesCommand;

@Component
public class GetAttributeTypesUseCase {

	@Autowired
	private AttributeTypePersistenceAdapter attributeType;

	public List<AttributeType> handle(GetAttributeTypesCommand command) {
		return attributeType.getAllAttributeTypes();
	}

}
