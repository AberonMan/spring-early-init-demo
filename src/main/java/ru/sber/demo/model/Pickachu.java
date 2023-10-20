package ru.sber.demo.model;

public class Pickachu extends AbstractPokemon {
    public Pickachu(String pockemonImage, boolean shiny) {
        super(pockemonImage, shiny);
    }
    
    @Override
    public PokemonType pockemonType() {
        return PokemonType.PICKACHU;
    }
}
