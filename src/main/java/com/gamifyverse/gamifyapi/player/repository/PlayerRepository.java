package com.gamifyverse.gamifyapi.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.player.repository.entity.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
