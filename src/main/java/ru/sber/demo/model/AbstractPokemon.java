package ru.sber.demo.model;

import ru.sber.demo.model.api.Pokemon;

public abstract class AbstractPokemon implements Pokemon {
    private final String pockemonImage;
    private final boolean shiny;
    
    protected AbstractPokemon(String pockemonImage, boolean shiny) {
        this.pockemonImage = pockemonImage;
        this.shiny = shiny;
    }
    
    @Override
    public String pockemonImage() {
        return pockemonImage;
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
