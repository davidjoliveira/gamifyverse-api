package com.gamifyverse.gamifyapi.trigger.repository.entity;

import com.gamifyverse.gamifyapi.attributes.repository.entity.AttributeEntity;

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

@Entity(name = "TriggerExecutionAttributeConfiguration")
@Table(name = "trigger_execution_attr_config", schema = "gamifyverse")
@Data
public class TriggerExecutionAttributeConfigurationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.trigger_execution_config_id_seq")
	private Long id;

	@JoinColumn(name = "trigger_id")
	@OneToOne
	private TriggerEntity trigger;

	@JoinColumn(name = "attribute_id")
	@ManyToOne
	private AttributeEntity attribute;

	@Column(name = "attribute_value")
	private Double executionTimes;
}
