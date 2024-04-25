package com.gamifyverse.gamifyapi.attributes.repository.entity;

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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Attribute")
@Table(name = "attribute", schema = "gamifyverse")
@Data
public class AttributeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gamifyverse.attribute_id_seq")
	@SequenceGenerator(schema = "gamifyverse", name = "attribute_id_seq", allocationSize = 1, initialValue = 1, sequenceName = "attribute_id_seq")
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name = "external_uuid")
	private UUID externalUUID;

	@Column(name = "attribute_type_id")
	private Integer attributeTypeId;

	@Column
	private Boolean active;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@ManyToOne
	@JoinColumn(name = "game_id")
	private GameEntity game;

}
