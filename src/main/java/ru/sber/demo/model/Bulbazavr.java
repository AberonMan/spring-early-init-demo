package ru.sber.demo.model;

public class Bulbazavr extends AbstractPokemon {
    
    public Bulbazavr(String bulbazavrImage, boolean shiny) {
        super(bulbazavrImage, shiny);
    }
    
    @Override
    public PokemonType pokemonType() {
        return PokemonType.BULBAZAVR;
    }
}
