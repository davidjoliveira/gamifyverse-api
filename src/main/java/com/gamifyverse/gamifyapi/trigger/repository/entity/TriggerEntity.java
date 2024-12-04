package com.gamifyverse.gamifyapi.trigger.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gamifyverse.gamifyapi.action.repository.entity.ActionEntity;
import com.gamifyverse.gamifyapi.attributes.repository.entity.AttributeEntity;
import com.gamifyverse.gamifyapi.game.repository.entity.GameEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Trigger")
@Table(name = "trigger", schema = "gamifyverse")
@Data
public class TriggerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.trigger_id_seq")
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

	@JoinColumn(name = "action_id")
	@ManyToOne
	private ActionEntity action;
	
	@JoinColumn(name = "attribute_id")
	@ManyToOne
	private AttributeEntity attribute;

	@JoinColumn(name = "trigger_type_id")
	@ManyToOne
	private TriggerTypeEntity triggerType;

	@JoinColumn(name = "trigger_effect_type_id")
	@ManyToOne
	private TriggerEffectTypeEntity triggerEffectType;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@Column
	private Boolean active;

}
