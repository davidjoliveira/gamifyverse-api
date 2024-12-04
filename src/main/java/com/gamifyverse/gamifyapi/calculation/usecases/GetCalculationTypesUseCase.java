package com.gamifyverse.gamifyapi.calculation.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.calculation.adapters.CalculationTypesValuesPersistenceAdapter;
import com.gamifyverse.gamifyapi.calculation.model.CalculationBonusType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationMathType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationTransformationType;
import com.gamifyverse.gamifyapi.calculation.model.CalculationType;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationBonusTypesCommand;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationMathTypesCommand;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationTransformationTypesCommand;
import com.gamifyverse.gamifyapi.calculation.usecases.command.GetCalculationTypesCommand;

@Component
public class GetCalculationTypesUseCase {
	@Autowired
	private CalculationTypesValuesPersistenceAdapter getCalculationTypes;

	public List<CalculationType> handle(GetCalculationTypesCommand command) {
		return getCalculationTypes.findAllCalculationTypes();
	}

	public List<CalculationMathType> handle(GetCalculationMathTypesCommand command) {
		return getCalculationTypes.findAllCalculationMathTypes();
	}

	public List<CalculationTransformationType> handle(GetCalculationTransformationTypesCommand command) {
		return getCalculationTypes.findAllCalculationTransformationTypes();
	}

	public List<CalculationBonusType> handle(GetCalculationBonusTypesCommand command) {
		return getCalculationTypes.findAllCalculationBonusTypes();
	}
}
