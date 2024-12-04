package com.gamifyverse.gamifyapi.trigger.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerCalculationAssociationEntity;

public interface TriggerCalculationRepository extends JpaRepository<TriggerCalculationAssociationEntity, Long> {

	@Query(name = "select tc from TriggerCalculationAssociation tc JOIN tc.trigger t WHERE t.externalUUID = ?0")
	public List<TriggerCalculationAssociationEntity> findByTriggerExternalUUID(UUID triggerUUID);
}
