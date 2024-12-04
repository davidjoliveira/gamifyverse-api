package com.gamifyverse.gamifyapi.calculation.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CalculationTransformationConfiguration")
@Table(name = "calculation_transformation_config", schema = "gamifyverse")
public class CalculationTransformationConfigurationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.calculation_transformation_config_id_seq")
	private Long id;

	@OneToOne
	@JoinColumn(name = "calculation_id", nullable = false)
	private CalculationEntity calculation;

	@ManyToOne
	@JoinColumn(name = "calculation_transformation_type_id", nullable = false)
	private CalculationTransformationTypeEntity calculationTransformationType;
}