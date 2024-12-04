package com.gamifyverse.gamifyapi.calculation.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationEntity;

@Repository
public interface CalculationRepository extends JpaRepository<CalculationEntity, Long> {

	@EntityGraph(value = "calculation-with-configurations", attributePaths = { "calculationMath",
			"calculationTransformation", "calculationBonus" })
	Optional<CalculationEntity> findByExternalUUID(UUID calculationUUID);

	@Query(name = "select c from Calculation c JOIN c.game g WHERE g.externalUUID = ?0")
	List<CalculationEntity> findByGameExternalUUID(UUID gameUUID);
	
}
