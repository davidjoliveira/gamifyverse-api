package com.gamifyverse.gamifyapi.calculation.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "CalculationMathConfiguration")
@Table(name = "calculation_math_config", schema = "gamifyverse")
public class CalculationMathConfigurationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.calculation_math_config_id_seq")
	private Long id;

	@OneToOne
	@JoinColumn(name = "calculation_id", nullable = false)
	private CalculationEntity calculation;

	@ManyToOne
	@JoinColumn(name = "calculation_math_type_id", nullable = false)
	private CalculationMathTypeEntity calculationMathType;

	@Column(name = "base_value", nullable = false)
	private Double baseValue;

}