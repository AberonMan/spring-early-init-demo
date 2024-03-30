package ru.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo")
@Data
public class PokemonConfigurationProperties {
    private String pikachuImage;
    private String bulbazavrImage;
}
