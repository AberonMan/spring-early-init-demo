package ru.sber.demo.dsl.pokemon;

import org.springframework.beans.factory.FactoryBean;
import ru.sber.demo.PokemonConfigurationProperties;
import ru.sber.demo.model.Bulbazavr;
import ru.sber.demo.model.Pickachu;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Важно, что тут {@link FactoryBean}!!
 */
public class PokemonFactoryBean implements FactoryBean<Pokemon> {
    
    private static final Random RANDOM = new Random();
    private final PokemonConfigurationProperties properties;
    private PokemonType type;
    
    public PokemonFactoryBean(PokemonConfigurationProperties configurationProperties, PokemonDsl dsl) {
        this.properties = configurationProperties;
        this.type = dsl.getType();
    }
    
    public PokemonFactoryBean(PokemonConfigurationProperties configurationProperties) {
        this.properties = configurationProperties;
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
    
    @Override
    public Pokemon getObject() throws Exception {
        boolean shiny = isShiny();
        switch(type) {
            case PICKACHU:
                return new Pickachu(
                    getPokemonImage(properties.pathToPickachu()),
                    shiny
                );
            case BULBAZAVR:
                return new Bulbazavr(
                    getPokemonImage(properties.pathToBulbazvr()),
                    shiny
                );
            default:
                throw new IllegalStateException();
        }
    }
    
    private boolean isShiny() {
        return RANDOM.nextInt() % 4096 == 1345;
    }
    
    private String getPokemonImage(String properties) throws IOException, URISyntaxException {
        return Files.readString(
            Paths.get(
                Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(properties)
                    .toURI()
            )
        );
    }
    
    @Override
    public Class<?> getObjectType() {
        switch(type) {
            case PICKACHU:
                return Pickachu.class;
            case BULBAZAVR:
                return Bulbazavr.class;
            default:
                throw new IllegalStateException();
        }
    }
    
    public PokemonFactoryBean withType(PokemonType type) {
        this.type = type;
        return this;
    }
}
