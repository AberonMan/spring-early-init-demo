package ru.demo

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "demo")
data class PokemonConfigurationProperties(
    val pikachuImage: String,
    val bulbazavrImage: String
)
