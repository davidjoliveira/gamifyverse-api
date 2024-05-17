package com.gamifyverse.gamifyapi.trigger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionRateConfigurationEntity;

public interface TriggerExecutionRateConfigurationRepository
		extends JpaRepository<TriggerExecutionRateConfigurationEntity, Long> {

}
