package com.gamifyverse.gamifyapi.modellayer.gamedomain.playersubdomain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Player {
    private Long id;
    private Long gameId;
    private Boolean active;
    private UUID externalUUID;
    private LocalDateTime creationDate;
}
