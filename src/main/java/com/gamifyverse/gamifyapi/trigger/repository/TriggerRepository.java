package com.gamifyverse.gamifyapi.trigger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamifyverse.gamifyapi.trigger.repository.entity.TriggerEntity;

@Repository
public interface TriggerRepository extends JpaRepository<TriggerEntity, Long> {

}
