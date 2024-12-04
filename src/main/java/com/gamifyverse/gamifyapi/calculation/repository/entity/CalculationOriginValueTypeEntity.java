package com.gamifyverse.gamifyapi.calculation.repository.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CalculationOriginValueType")
@Table(name = "calculation_origin_value_type", schema = "gamifyverse")
public class CalculationOriginValueTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.calculation_origin_value_type_id_seq")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "external_uuid")
	private UUID externalUUID;
}