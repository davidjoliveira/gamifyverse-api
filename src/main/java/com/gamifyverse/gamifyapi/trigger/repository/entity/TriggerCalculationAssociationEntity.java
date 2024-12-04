package com.gamifyverse.gamifyapi.trigger.repository.entity;

import com.gamifyverse.gamifyapi.calculation.repository.entity.CalculationEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "TriggerCalculationAssociation")
@Table(name = "trigger_calculation", schema = "gamifyverse")
@Data
public class TriggerCalculationAssociationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.trigger_calculation_id_seq")
	private Long id;

	@JoinColumn(name = "trigger_id")
	@ManyToOne
	private TriggerEntity trigger;

	@JoinColumn(name = "calculation_id")
	@ManyToOne
	private CalculationEntity calculation;

	@Column(name = "execution_order")
	private Integer order;

	@Column
	private Boolean active;
}
