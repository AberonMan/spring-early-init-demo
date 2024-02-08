package ru.sber.demo.utils;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import ru.sber.demo.PokemonConfigurationPropertiesClass;
import ru.sber.demo.model.Pokemon;
import ru.sber.demo.model.PokemonDsl;
import ru.sber.demo.model.PokemonType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public final class PokemonFactoryBean extends AbstractFactoryBean<Pokemon> {
    
    private final PokemonType pokemonType;
    
    private final PokemonConfigurationPropertiesClass configurationProperties;
    
    public PokemonFactoryBean(PokemonDsl pokemonType, PokemonConfigurationPropertiesClass configurationProperties) {
        this.pokemonType = pokemonType.getType();
        this.configurationProperties = configurationProperties;
    }
    
    @Override
    public Class<?> getObjectType() {
        return Pokemon.class;
    }
    
    @Override
    protected Pokemon createInstance() throws IOException, URISyntaxException {
        return createPokemon(pokemonType, configurationProperties);
    }
    
    private Pokemon createPokemon(
        PokemonType pokemonType,
        PokemonConfigurationPropertiesClass pokemonConfigurationProperties) throws IOException, URISyntaxException {
        
        // у нас самый демократичный зоопарк, половина покемонов shiny, а половина нет.
        final boolean shiny = ThreadLocalRandom.current().nextBoolean();
        
        return switch (pokemonType) {
            case PICKACHU ->
                new Pokemon(getPokemonImage(pokemonConfigurationProperties.pikachuImage()), pokemonType, shiny);
            case BULBAZAVR ->
                new Pokemon(getPokemonImage(pokemonConfigurationProperties.bulbazavrImage()), pokemonType, shiny);
        };
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
}
