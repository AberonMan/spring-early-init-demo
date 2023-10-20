package ru.sber.demo.model.api;

import ru.sber.demo.dsl.pockemon.PokemonDsl;
import ru.sber.demo.model.PokemonType;

public interface Pokemon {
    String pockemonImage();
    PokemonType pockemonType();
    boolean isShiny();
    
    static PokemonDsl catchPokemon(PokemonType type) {
        return new PokemonDsl(type);
    }
}
