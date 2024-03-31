package ru.demo.model;

public class PokemonMaster {
    
    public PokemonMaster(String masterName, Pokemon pokemon) {
        System.out.println("Я покемон-мастер " + masterName + "!");
        System.out.println("Я тренирую его!");
        System.out.println(pokemon.pokemonImage());
        System.out.println("=======================");
    }
}
