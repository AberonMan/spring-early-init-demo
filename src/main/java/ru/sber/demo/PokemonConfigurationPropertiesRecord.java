package ru.sber.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo")
public record PokemonConfigurationPropertiesRecord(String pikachuImage, String bulbazavrImage) {}
