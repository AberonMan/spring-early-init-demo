package ru.sber.demo.model;

import ru.sber.demo.model.api.Pokemon;

public class PokemonMaster {

    public PokemonMaster(String name, Pokemon pokemon) {
        System.out.println("Я покемон-мастер " + name + "!");
        System.out.println("Я тренирую его!");
        System.out.println(pokemon.pokemonImage());
        System.out.println("=======================");
    }
}
