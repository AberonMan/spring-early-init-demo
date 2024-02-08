package ru.sber.demo.model;

public class PokemonMaster {
    
    public PokemonMaster(PokemonDsl pokemonDsl, Pokemon pokemon) {
        this(pokemonDsl.getMasterName(), pokemon);
    }
    
    public PokemonMaster(String name, Pokemon pokemon) {
        System.out.println("Я покемон-мастер " + name + "!");
        System.out.println("Я тренирую его!");
        System.out.println(pokemon.pokemonImage());
        System.out.println("=======================");
    }
}
