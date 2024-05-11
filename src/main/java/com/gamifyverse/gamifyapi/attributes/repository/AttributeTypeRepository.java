package com.gamifyverse.gamifyapi.attributes.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.attributes.repository.entity.AttributeTypeEntity;

@Repository
public interface AttributeTypeRepository extends JpaRepository<AttributeTypeEntity, Long> {

	public Optional<AttributeTypeEntity> findByExternalUUID(UUID externalUUID);

}
