package com.gamifyverse.gamifyapi.action.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gamifyverse.gamifyapi.action.repository.entity.ActionEntity;

public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
	@Query(name = "select a from Action a JOIN a.game g WHERE g.externalUUID = ?0 AND a.active = ?1")
	public List<ActionEntity> findByGameExternalUUIDAndActive(UUID gameUUID, Boolean active);

	public Optional<ActionEntity> findByExternalUUID(UUID actionUUID);
}
