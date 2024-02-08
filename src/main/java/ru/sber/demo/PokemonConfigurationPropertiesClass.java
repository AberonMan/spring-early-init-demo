package ru.sber.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo")
public class PokemonConfigurationPropertiesClass {
    String pikachuImage;
    String bulbazavrImage;
    
    public String pikachuImage() {
        return pikachuImage;
    }
    
    public void setPikachuImage(String pikachuImage) {
        this.pikachuImage = pikachuImage;
    }
    
    public String bulbazavrImage() {
        return bulbazavrImage;
    }
    
    public void setBulbazavrImage(String bulbazavrImage) {
        this.bulbazavrImage = bulbazavrImage;
    }
}
