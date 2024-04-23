package com.gamifyverse.gamifyapi.game.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "GameApiConfiguration")
@Table(name = "game_api_configurations", schema = "gamifyverse")
@Data
public class GameAPIConfigurationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gamifyverse.game_api_configurations_id_seq")
	@SequenceGenerator(schema = "gamifyverse", name = "game_api_configurations_id_seq", allocationSize = 1, initialValue = 1, sequenceName = "game_api_configurations_id_seq")
	private Long id;

	@JoinColumn(name = "game_id")
	@OneToOne
	private GameEntity game;

	@Column(name = "callback_url")
	private String callbackUrl;
}
