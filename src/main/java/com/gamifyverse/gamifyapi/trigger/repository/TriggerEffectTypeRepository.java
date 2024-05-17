package com.gamifyverse.gamifyapi.trigger.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerEffectTypeEntity;

@Repository
public interface TriggerEffectTypeRepository extends JpaRepository<TriggerEffectTypeEntity, Long> {
	Optional<TriggerEffectTypeEntity> findByExternalUUID(UUID triggerEffectUUID);
}
