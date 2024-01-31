package ru.sber.demo.utils;

import ru.sber.demo.PokemonConfigurationProperties;
import ru.sber.demo.model.Pokemon;
import ru.sber.demo.model.PokemonType;

import java.util.concurrent.ThreadLocalRandom;

public final class PockemonFactory {
    
    private PockemonFactory() {
        throw new IllegalStateException("Can't create pockemon factory!");
    }
    
    public static Pokemon createPokemon(
        PokemonType pokemonType,
        PokemonConfigurationProperties pokemonConfigurationProperties) {
        
        // у нас самый демократичный зоопарк, половина покемонов shiny, а половина нет.
        final boolean shiny = ThreadLocalRandom.current().nextBoolean();
        
        return switch (pokemonType) {
            case PICKACHU -> new Pokemon(pokemonConfigurationProperties.pikachuImage(), pokemonType, shiny);
            case BULBAZAVR -> new Pokemon(pokemonConfigurationProperties.bulbazavrImage(), pokemonType, shiny);
        };
    }
}
