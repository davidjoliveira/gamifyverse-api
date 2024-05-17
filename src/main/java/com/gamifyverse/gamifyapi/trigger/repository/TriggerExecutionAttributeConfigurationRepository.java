package com.gamifyverse.gamifyapi.trigger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerExecutionAttributeConfigurationEntity;

@Repository
public interface TriggerExecutionAttributeConfigurationRepository
		extends JpaRepository<TriggerExecutionAttributeConfigurationEntity, Long> {

}
