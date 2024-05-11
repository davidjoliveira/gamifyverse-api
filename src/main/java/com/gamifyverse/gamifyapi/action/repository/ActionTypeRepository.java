package com.gamifyverse.gamifyapi.action.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamifyverse.gamifyapi.action.repository.entity.ActionTypeEntity;

public interface ActionTypeRepository extends JpaRepository<ActionTypeEntity, Long> {
	public Optional<ActionTypeEntity> findByExternalUUID(UUID externalUUID);
}
