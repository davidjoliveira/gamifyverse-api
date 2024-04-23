package com.gamifyverse.gamifyapi.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.game.repository.entity.GameAPIConfigurationEntity;

@Repository
public interface GameAPIConfigurationRepository extends JpaRepository<GameAPIConfigurationEntity, Long> {
}
