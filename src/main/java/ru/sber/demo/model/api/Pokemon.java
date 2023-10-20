package ru.sber.demo.model.api;

import ru.sber.demo.dsl.pokemon.PokemonDsl;
import ru.sber.demo.model.PokemonType;

public interface Pokemon {
    String pokemonImage();
    PokemonType pokemonType();
    boolean isShiny();
    
    static PokemonDsl catchPokemon(PokemonType type) {
        return new PokemonDsl(type);
    }
}
