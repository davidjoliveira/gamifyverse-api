package com.gamifyverse.gamifyapi.trigger.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerEntity;

@Repository
public interface TriggerRepository extends JpaRepository<TriggerEntity, Long> {
	@Query(name = "select t from Trigger t JOIN t.game g WHERE g.externalUUID = ?0 and t.active = ?1")
	List<TriggerEntity> findByGameExternalUUIDAndActive(UUID gameUUID, Boolean active);

	Optional<TriggerEntity> findByExternalUUID(UUID triggerUUID);
}
