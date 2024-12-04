package com.gamifyverse.gamifyapi.calculation.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gamifyverse.gamifyapi.game.repository.entity.GameEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Calculation")
@Table(name = "calculation", schema = "gamifyverse")
@Data
public class CalculationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.calculation_id_seq")
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name = "external_uuid")
	private UUID externalUUID;

	@ManyToOne
	@JoinColumn(name = "game_id")
	private GameEntity game;

	@JoinColumn(name = "calculation_type_id")
	@ManyToOne
	private CalculationTypeEntity calculationType;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@OneToOne(mappedBy = "calculation")
	private CalculationMathConfigurationEntity calculationMath;

	@OneToOne(mappedBy = "calculation")
	private CalculationTransformationConfigurationEntity calculationTransformation;

	@OneToOne(mappedBy = "calculation")
	private CalculationBonusConfigurationEntity calculationBonus;
}
