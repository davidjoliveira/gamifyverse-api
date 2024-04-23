package com.gamifyverse.gamifyapi.game.repository.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Game")
@Table(name = "game", schema = "gamifyverse")
@Data
public class GameEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gamifyverse.game_id_seq")
	@SequenceGenerator(schema = "gamifyverse", name = "game_id_seq", allocationSize = 1, initialValue = 1, sequenceName = "game_id_seq")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column(name = "external_uuid")
	private UUID externalUUID;
	
	@OneToOne(mappedBy = "game")
	private GameAPIConfigurationEntity apiConfiguration;
}
