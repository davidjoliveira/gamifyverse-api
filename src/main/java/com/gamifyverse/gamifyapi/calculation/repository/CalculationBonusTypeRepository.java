package com.gamifyverse.gamifyapi.calculation.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationBonusTypeEntity;

@Repository
public interface CalculationBonusTypeRepository extends JpaRepository<CalculationBonusTypeEntity, Long> {
	Optional<CalculationBonusTypeEntity> findByExternalUUID(UUID triggerTypeUUID);
}
