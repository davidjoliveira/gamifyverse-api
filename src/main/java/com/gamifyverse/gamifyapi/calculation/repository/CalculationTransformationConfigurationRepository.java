package com.gamifyverse.gamifyapi.calculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationTransformationConfigurationEntity;

@Repository
public interface CalculationTransformationConfigurationRepository
		extends JpaRepository<CalculationTransformationConfigurationEntity, Long> {

}
