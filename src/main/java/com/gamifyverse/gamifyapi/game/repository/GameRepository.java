package com.gamifyverse.gamifyapi.game.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.game.repository.entity.GameEntity;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {

	public Optional<GameEntity> findByExternalUUID(UUID externalUUID);

}
