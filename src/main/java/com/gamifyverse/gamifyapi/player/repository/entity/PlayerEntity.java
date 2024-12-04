package com.gamifyverse.gamifyapi.player.repository.entity;

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
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Player")
@Table(name = "player", schema = "gamifyverse")
@Data
public class PlayerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.player_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "game_id")
	private GameEntity game;

	@Column(name = "external_uuid")
	private UUID externalUUID;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@Column
	private Boolean active;

}
