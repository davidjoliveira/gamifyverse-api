package com.gamifyverse.gamifyapi.trigger.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerRateTypeEntity;

@Repository
public interface TriggerRateTypeRepository extends JpaRepository<TriggerRateTypeEntity, Long> {
	Optional<TriggerRateTypeEntity> findByExternalUUID(UUID triggerRateUUID);
}
