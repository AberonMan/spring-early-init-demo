package ru.sber.demo.model;

public class Pickachu extends AbstractPokemon {
    public Pickachu(String pokemonImage, boolean shiny) {
        super(pokemonImage, shiny);
    }
    
    @Override
    public PokemonType pokemonType() {
        return PokemonType.PICKACHU;
    }
}
