package com.gamifyverse.gamifyapi.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameAPIConfiguration {
    private Long id;
    private Long gameId;
    private String callbackUrl;
}
