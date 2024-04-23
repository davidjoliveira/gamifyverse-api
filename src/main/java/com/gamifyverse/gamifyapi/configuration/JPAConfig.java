package com.gamifyverse.gamifyapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.gamifyverse.gamifyapi.game.repository"})
public class JPAConfig {

}
