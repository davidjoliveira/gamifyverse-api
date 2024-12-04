package com.gamifyverse.gamifyapi.player.adapters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamifyverse.gamifyapi.player.adapters.PlayerPersistenceAdapter;
import com.gamifyverse.gamifyapi.player.adapters.mappers.PlayerEntityMapper;
import com.gamifyverse.gamifyapi.player.model.Player;
import com.gamifyverse.gamifyapi.player.repository.PlayerRepository;
import com.gamifyverse.gamifyapi.player.repository.entity.PlayerEntity;

@Component
public class PlayerPersistenceAdapterImpl implements PlayerPersistenceAdapter {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerEntityMapper playerMapper;

	@Override
	public Player createPlayer(Player player) {
		PlayerEntity entity = playerMapper.toEntity(player);
		return playerMapper.toDomain(playerRepository.save(entity));
	}

}
