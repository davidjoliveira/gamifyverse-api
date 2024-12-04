package com.gamifyverse.gamifyapi.trigger.repository.entity;

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

@Entity(name = "TriggerExecutionRateConfiguration")
@Table(name = "trigger_execution_rate_config", schema = "gamifyverse")
@Data
public class TriggerExecutionRateConfigurationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.trigger_execution_rate_config_id_seq")
	private Long id;

	@JoinColumn(name = "trigger_id")
	@OneToOne
	private TriggerEntity trigger;

	@JoinColumn(name = "trigger_rate_type_id")
	@ManyToOne
	private TriggerRateTypeEntity triggerRateType;

	@Column(name = "base_rate")
	private Double baseRate;

	@Column(name = "increment_rate")
	private Double incrementRate;
}
