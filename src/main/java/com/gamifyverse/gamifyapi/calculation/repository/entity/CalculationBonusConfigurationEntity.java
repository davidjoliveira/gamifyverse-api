package com.gamifyverse.gamifyapi.calculation.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "CalculationBonusConfiguration")
@Table(name = "calculation_bonus_config", schema = "gamifyverse")
public class CalculationBonusConfigurationEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamifyverse.calculation_bonus_config_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "calculation_id", nullable = false)
    private CalculationEntity calculation;

    @ManyToOne
    @JoinColumn(name = "calculation_bonus_type_id", nullable = false)
    private CalculationBonusTypeEntity calculationBonusType;

    @Column(name = "bonus_base_value", nullable = false)
    private Double bonusBaseValue;

    @Column(name = "bonus_upper_value")
    private Double bonusUpperValue;
}