package com.gamifyverse.gamifyapi.calculation.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.calculation.adapters.CalculationPersistenceAdapter;
import com.gamifyverse.gamifyapi.calculation.model.Calculation;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationsByGameCommand;

@Component
public class GetCalculationsUseCase {

	@Autowired
	private CalculationPersistenceAdapter calculationPersistenceAdapter;

	public List<Calculation> handle(GetCalculationsByGameCommand command) {
		return calculationPersistenceAdapter.getCalculationsByGameUUID(command.getGameUUID());
	}

}
