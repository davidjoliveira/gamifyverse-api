package com.gamifyverse.gamifyapi.calculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationBonusConfigurationEntity;

@Repository
public interface CalculationBonusConfigurationRepository
		extends JpaRepository<CalculationBonusConfigurationEntity, Long> {

}
