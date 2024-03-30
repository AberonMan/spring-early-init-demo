package ru.demo.model;

public class PokemonMaster {
    
    public PokemonMaster(PokemonDsl pokemonDsl, Pokemon pokemon) {
        System.out.println("Я покемон-мастер " + pokemonDsl.getMasterName() + "!");
        System.out.println("Я тренирую его!");
        System.out.println(pokemon.pokemonImage());
        System.out.println("=======================");
    }
}
