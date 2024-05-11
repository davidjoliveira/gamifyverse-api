package com.gamifyverse.gamifyapi.action.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamifyverse.gamifyapi.action.repository.entity.ScheduleTypeEntity;

public interface ScheduleTypeRepository extends JpaRepository<ScheduleTypeEntity, Long> {
	public Optional<ScheduleTypeEntity> findByExternalUUID(UUID externalUUID);
}
