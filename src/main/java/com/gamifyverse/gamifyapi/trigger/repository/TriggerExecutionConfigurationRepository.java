package com.gamifyverse.gamifyapi.trigger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionConfigurationEntity;

@Repository
public interface TriggerExecutionConfigurationRepository
		extends JpaRepository<TriggerExecutionConfigurationEntity, Long> {

}
