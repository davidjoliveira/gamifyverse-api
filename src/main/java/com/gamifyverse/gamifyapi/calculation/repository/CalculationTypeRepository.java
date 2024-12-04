package com.gamifyverse.gamifyapi.calculation.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationTypeEntity;

@Repository
public interface CalculationTypeRepository extends JpaRepository<CalculationTypeEntity, Long> {
	Optional<CalculationTypeEntity> findByExternalUUID(UUID triggerTypeUUID);
}
