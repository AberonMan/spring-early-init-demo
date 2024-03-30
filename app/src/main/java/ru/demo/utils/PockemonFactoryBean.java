package ru.demo.utils;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.demo.PokemonConfigurationProperties;
import ru.demo.model.Pokemon;
import ru.demo.model.PokemonDsl;
import ru.demo.model.PokemonType;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.currentThread;

@RequiredArgsConstructor
public final class PockemonFactoryBean extends AbstractFactoryBean<Pokemon> {
    
    private final PokemonDsl pokemonDsl;
    
    private final PokemonConfigurationProperties configurationProperties;
    
    @Override
    public Class<?> getObjectType() {
        return Pokemon.class;
    }
    
    @Override
    protected Pokemon createInstance() {
        return createPokemon(pokemonDsl.getType(), configurationProperties);
    }
    
    public Pokemon createPokemon(
        PokemonType pokemonType,
        PokemonConfigurationProperties pokemonConfigurationProperties) {
        
        // у нас самый демократичный зоопарк, половина покемонов shiny, а половина нет.
        final boolean shiny = ThreadLocalRandom.current().nextBoolean();
        
        return switch (pokemonType) {
            case PICKACHU ->
                new Pokemon(loadImage(pokemonConfigurationProperties.getPikachuImage()), pokemonType, shiny);
            case BULBAZAVR ->
                new Pokemon(loadImage(pokemonConfigurationProperties.getBulbazavrImage()), pokemonType, shiny);
        };
    }
    
    @SneakyThrows
    private String loadImage(String pokemonImagePath) {
        final URL resource = currentThread().getContextClassLoader().getResource(pokemonImagePath);
        final String image = Files.readString(Paths.get(
            Objects.requireNonNull(resource, "Can't find pokemon imager: %s".formatted(pokemonImagePath)).toURI()));
        System.out.println(image);
        return image;
    }
}
