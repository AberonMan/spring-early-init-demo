package ru.sber.demo.model;

import ru.sber.demo.model.api.Pokemon;

public class PokemonMaster {
    private final String name;
    private final Pokemon pokemon;
    
    public PokemonMaster(String name, Pokemon pokemon) {
        System.out.println("Я покемон-мастер " + name + "!");
        System.out.println("Я тренирую его!");
        System.out.println(pokemon.pokemonImage());
        System.out.println("=======================");
        this.pokemon = pokemon;
        this.name = name;
    }
}
