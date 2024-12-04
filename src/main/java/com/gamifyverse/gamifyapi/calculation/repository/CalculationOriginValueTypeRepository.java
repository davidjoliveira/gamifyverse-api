package com.gamifyverse.gamifyapi.calculation.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationOriginValueTypeEntity;

@Repository
public interface CalculationOriginValueTypeRepository extends JpaRepository<CalculationOriginValueTypeEntity, Long> {
	Optional<CalculationOriginValueTypeEntity> findByExternalUUID(UUID triggerEffectUUID);
}
