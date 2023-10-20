package ru.sber.demo.model;

import ru.sber.demo.model.api.Pokemon;

public abstract class AbstractPokemon implements Pokemon {
    private final String pokemonImage;
    private final boolean shiny;
    
    protected AbstractPokemon(String pokemonImage, boolean shiny) {
        this.pokemonImage = pokemonImage;
        this.shiny = shiny;
    }
    
    @Override
    public String pokemonImage() {
        return pokemonImage;
    }
    
    @Override
    public boolean isShiny() {
        return shiny;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
