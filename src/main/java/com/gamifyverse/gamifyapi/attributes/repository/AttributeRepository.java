package com.gamifyverse.gamifyapi.attributes.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.attributes.repository.entity.AttributeEntity;

@Repository
public interface AttributeRepository extends JpaRepository<AttributeEntity, Long> {

	@Query(name = "select a from Attribute a JOIN a.game g WHERE g.externalUUID = ?0 AND a.active = ?1")
	public List<AttributeEntity> getByGameExternalUUIDAndActive(UUID gameUUID, Boolean active);

}
