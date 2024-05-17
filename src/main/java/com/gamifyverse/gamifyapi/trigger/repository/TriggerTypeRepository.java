package com.gamifyverse.gamifyapi.trigger.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerTypeEntity;

@Repository
public interface TriggerTypeRepository extends JpaRepository<TriggerTypeEntity, Long> {
	Optional<TriggerTypeEntity> findByExternalUUID(UUID triggerTypeUUID);
}
