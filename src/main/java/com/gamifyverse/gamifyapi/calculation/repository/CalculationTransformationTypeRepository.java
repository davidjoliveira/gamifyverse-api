package com.gamifyverse.gamifyapi.calculation.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationTransformationTypeEntity;

@Repository
public interface CalculationTransformationTypeRepository
		extends JpaRepository<CalculationTransformationTypeEntity, Long> {
	Optional<CalculationTransformationTypeEntity> findByExternalUUID(UUID triggerEffectUUID);
}
