package com.gamifyverse.gamifyapi.trigger.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "TriggerExecutionConfiguration")
@Table(name = "trigger_execution_config", schema = "gamifyverse")
@Data
public class TriggerExecutionConfigurationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.trigger_execution_config_id_seq")
	private Long id;

	@JoinColumn(name = "trigger_id")
	@OneToOne
	private TriggerEntity trigger;

	@Column(name = "execution_times")
	private Integer executionTimes;
}
