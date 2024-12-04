package com.gamifyverse.gamifyapi.calculation.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationMathTypeEntity;

@Repository
public interface CalculationMathTypeRepository extends JpaRepository<CalculationMathTypeEntity, Long> {
	Optional<CalculationMathTypeEntity> findByExternalUUID(UUID triggerTypeUUID);
}
