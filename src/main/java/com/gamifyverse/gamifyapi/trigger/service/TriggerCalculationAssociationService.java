package com.gamifyverse.gamifyapi.trigger.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamifyverse.gamifyapi.calculation.model.Calculation;
import com.gamifyverse.gamifyapi.calculation.service.CalculationService;
import com.gamifyverse.gamifyapi.trigger.model.Trigger;
import com.gamifyverse.gamifyapi.trigger.model.TriggerCalculationAssociation;

import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog
public class TriggerCalculationAssociationService {

	@Autowired
	private CalculationService calculationService;

	private CompletableFuture<TriggerCalculationAssociation> merge(List<TriggerCalculationAssociation> currentData,
			List<UUID> newCalculations, Trigger trigger, int idx) {
		if (idx >= currentData.size()) {
			CompletableFuture<Calculation> calculationFuture = calculationService
					.findCalculation(newCalculations.get(idx));
			return calculationFuture.thenCompose((calculation) -> {
				return CompletableFuture.<TriggerCalculationAssociation>completedFuture(
						TriggerCalculationAssociation.from(trigger, calculation, idx + 1));
			});
		} else if (idx >= newCalculations.size()) {
			currentData.get(idx).setActive(Boolean.FALSE);
			return CompletableFuture.<TriggerCalculationAssociation>completedFuture(currentData.get(idx));
		}
		if (!currentData.get(idx).getCalculation().getExternalUUID().equals(newCalculations.get(idx))) {
			CompletableFuture<Calculation> calculationFuture = calculationService
					.findCalculation(newCalculations.get(idx));
			calculationFuture.thenApplyAsync(calculation -> {
				currentData.get(idx).setCalculation(calculation);
				return currentData.get(idx);
			});
		}
		return CompletableFuture.completedFuture(currentData.get(idx));
	}

	public List<TriggerCalculationAssociation> mergeData(List<TriggerCalculationAssociation> currentData,
			List<UUID> newCalculations, Trigger trigger) {
		int N = Math.max(currentData.size(), newCalculations.size());
		List<TriggerCalculationAssociation> newData = new CopyOnWriteArrayList<TriggerCalculationAssociation>();
		CompletableFuture<TriggerCalculationAssociation>[] futures = new CompletableFuture[N];
		for (int i = 0; i < N; i++) {
			CompletableFuture<TriggerCalculationAssociation> future = merge(currentData, newCalculations, trigger, i);
			futures[i] = future;
			future.thenApplyAsync(association -> newData.add(association));
		}
		try {
			CompletableFuture.allOf(futures).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		log.info(String.format("CREATING NEW ASSOCIATIONS %s", newData.stream().map(n -> n.getId()+"").collect(Collectors.joining(","))));
		return newData;
	}

}
