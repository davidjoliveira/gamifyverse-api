package com.gamifyverse.gamifyapi.calculation.repository.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "CalculationBonusType")
@Table(name = "calculation_bonus_type", schema = "gamifyverse")
public class CalculationBonusTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.calculation_bonus_type_id_seq")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "external_uuid")
	private UUID externalUUID;
}