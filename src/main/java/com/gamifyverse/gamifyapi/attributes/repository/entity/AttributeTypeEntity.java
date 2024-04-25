package com.gamifyverse.gamifyapi.attributes.repository.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "AttributeType")
@Table(name = "attribute_type", schema = "gamifyverse")
@Data
public class AttributeTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gamifyverse.attribute_type_id_seq")
	@SequenceGenerator(schema = "gamifyverse", name = "attribute_type_id_seq", allocationSize = 1, initialValue = 1, sequenceName = "attribute_type_id_seq")
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name = "external_uuid")
	private UUID externalUUID;

}
